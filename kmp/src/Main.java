import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String S = "aabcabcabxx";
        String T = "abcabx";
        Arrays.stream(get_next(T)).mapToObj(x -> x + ",").forEach(System.out::print);
        System.out.println();
        System.out.println(Index_KMP(S, T, 0));
    }

    //next[j]肯定比 j 小
    static int[] get_next(String T) {
        int length = T.length();
        int[] next = new int[length];
        int the_end = 2, the_start = 0;
        next[0] = 0;
        next[1] = 0;
        while (the_end < length - 1) {
            //i表示前缀的单个字符
            //j表示后缀的单个字符
            if (T.charAt(the_start) == T.charAt(the_end)) {
                the_start++;
                the_end++;
                next[the_end] = the_start;
            } else if (the_start == 0) {
                next[the_end++] = 0;
            } else {
                the_start = next[the_start];
            }
        }
        return next;
    }


    //朴素算法
    static int Index_Plain(String S, String T, int pos) {

        return 0;
    }


    //只是建立T 的next
    // 并没有根据 S 来优化，即S[0]=T[0],S[0]=S[1],应该直接跳过S[1]
    //不过这样比较和那T来比较S[1]需要一样多的步骤
    //所以目前没什么问题
    static int Index_KMP(String S, String T, int pos) {
        int i = pos;
        int j = 0;
        int[] next = get_next(T);
        while (i < S.length() && j < T.length()) {
            if (S.charAt(i) == T.charAt(j)) {
//                System.out.println(S.charAt(i)+"不等于"+T.charAt(j));
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        if (j >= T.length())
            return i - T.length();
        return 0;
    }
}

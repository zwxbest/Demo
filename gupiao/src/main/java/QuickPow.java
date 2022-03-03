//参考：https://www.cnblogs.com/cmmdc/p/6936196.html
public class QuickPow {

    int quickPow(int x, int n) {
//        当前位置的二进制数，比如19是10011，倒数第二个1的时候，curPow是x的平方
        int cur = x;
        int res = 1;
        while (n != 0) {
            //当前位是1，乘上去，例如10011,乘以x^2，乘以x^1
            if ((n & 1) == 1) {
                res = res * cur;
            }
            n = n >> 1; //n往前进以为
            cur = cur * cur;//x^n * x^n= x^2n,因为是二进制，n往前一位就是2n
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new QuickPow().quickPow(3,5));
        System.out.println(new QuickPow().quickPow(8,4));

    }
}

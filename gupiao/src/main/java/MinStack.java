import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    Deque<Integer> stack, minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        int len = s.length();
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            int j = i;
            int k = (i - n + len) % len;
            while(k != i) {
                chars[k] = chars[j];
                j = k;
                k = (j - n + len) % len;
            }
            chars[i] = chars[j];
        }
        System.out.println(chars);
    }


}

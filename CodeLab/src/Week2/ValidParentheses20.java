package Week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        char[] parentheses = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : parentheses) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (stack.isEmpty() || stack.pollFirst() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

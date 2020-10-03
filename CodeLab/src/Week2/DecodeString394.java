package Week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString394 {
    public String decodeString(String s) {
        Deque<Integer> intStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }
}

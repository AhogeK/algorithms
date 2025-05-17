package stackqueue;

/**
 * 20. 有效的括号
 *
 * @author AhogeK
 * @since 2025-05-17 22:32:24
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top < 0) return false;
                char left = stack[top--];
                if (c == ')' && left != '(' || c == ']' && left != '[' || c == '}' && left != '{') return false;
            }
        }
        return top == -1;
    }
}

package stackqueue;

/**
 * 150. 逆波兰表达式求值
 *
 * @author AhogeK
 * @since 2025-05-17 23:00:47
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            char c = token.charAt(0);
            if (token.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
                int b = stack[top--];
                int a = stack[top--];
                int res = switch (c) {
                    case '+' -> a + b;
                    case '-' -> a - b;
                    case '*' -> a * b;
                    case '/' -> a / b;
                    default -> 0;
                };
                stack[++top] = res;
            } else {
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
}

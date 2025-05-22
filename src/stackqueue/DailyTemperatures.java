package stackqueue;

/**
 * 739. 每日温度
 *
 * @author AhogeK
 * @since 2025-05-23 00:39:47
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; ++i) {
            while (top >= 0 &&  temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                answer[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return answer;
    }
}

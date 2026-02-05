package contest.nowcoder.daily.twentysix.february.fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <a href="https://www.nowcoder.com/practice/a2d5b1875bb0408384278f40d1f236c9?channelPut=tracker2">括号匹配深度</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-05 19:58:29
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cur = 0, best = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cur++;
                if (cur > best) best = cur;
            } else {
                cur--;
            }
        }
        System.out.println(best);
    }
}

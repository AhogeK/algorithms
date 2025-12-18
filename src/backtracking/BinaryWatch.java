package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-19 05:31:09
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>(256);
        if (turnedOn > 8) return ans;
        backtrack(0, 0, 10, turnedOn, ans);
        return ans;
    }

    private void backtrack(int path, int i, int len, int total, List<String> ans) {
        if (total == 0) {
            int h = path >> 6;
            int m = path & 0x3F;
            if (h < 12 && m < 60) {
                StringBuilder sb = new StringBuilder(5);
                sb.append(h).append(':');
                if (m < 10) sb.append('0');
                sb.append(m);
                ans.add(sb.toString());
            }
            return;
        }
        if (len - i < total) return;
        backtrack(path, i + 1, len, total, ans);
        backtrack(path | (1 << i), i + 1, len, total - 1, ans);
    }
}

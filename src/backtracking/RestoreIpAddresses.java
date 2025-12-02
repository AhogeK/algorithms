package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-02 19:52:11
 */
public class RestoreIpAddresses {
    private List<String> ans;
    private char[] sArr;
    private char[] path;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) return ans;

        sArr = s.toCharArray();
        path = new char[n + 3];

        backtrack(0, 0, 0);
        return ans;
    }

    private void backtrack(int sIdx, int pIdx, int segment) {
        int remainChar = sArr.length - sIdx;
        int remainSegment = 4 - segment;
        if (remainChar < remainSegment || remainChar > remainSegment * 3) return;
        if (segment == 4) {
            ans.add(new String(path));
            return;
        }
        int val = 0;
        for (int i = 1; i <= 3; i++) {
            if (sIdx + i - 1 >= sArr.length) break;
            char c = sArr[sIdx + i - 1];
            val = val * 10 + (c - '0');
            if (val > 255) break;
            if (i > 1 && sArr[sIdx] == '0') break;
            path[pIdx + i - 1] = c;
            if (segment < 3) {
                path[pIdx + i] = '.';
                backtrack(sIdx + i, pIdx + i + 1, segment + 1);
            } else {
                backtrack(sIdx + i, pIdx + i, segment + 1);
            }
        }
    }
}

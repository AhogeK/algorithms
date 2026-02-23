package contest.leetcode.daily.twentysix.february;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-23 10:22:33
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int target = 1 << k;
        if (n - k + 1 < target) return false;
        boolean[] seen = new boolean[target];
        int count = 0;
        int hash = 0;
        int mask = target - 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            hash = ((hash << 1) & mask) | (chars[i] - '0');
            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                count++;
                if (count == target) return true;
            }
        }
        return false;
    }
}

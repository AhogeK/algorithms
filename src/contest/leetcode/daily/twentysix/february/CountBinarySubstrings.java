package contest.leetcode.daily.twentysix.february;

/**
 * 696. 计数二进制子串
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-19 06:10:13
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] cs = s.toCharArray();
        int pre = 0, cur = 1, ans = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == cs[i - 1]) cur++;
            else {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return ans + Math.min(pre, cur);
    }
}

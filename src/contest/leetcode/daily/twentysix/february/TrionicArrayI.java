package contest.leetcode.daily.twentysix.february;

/**
 * 3637. 三段式数组 I
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-03 16:34:06
 */
public class TrionicArrayI {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;
        int i = 1;
        int start = i;
        while (i < n && nums[i] > nums[i - 1]) i++;
        if (i == start) return false;
        start = i;
        while (i < n && nums[i] <  nums[i - 1]) i++;
        if (i == start) return false;
        start = i;
        while (i < n && nums[i] > nums[i - 1]) i++;
        if (i == start) return false;
        return i == n;
    }
}

package contest.leetcode.daily.twentysix.jan;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-02 18:45:41
 */
public class NRepeatedElementInSizeTwoNArray {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if (i + 1 < n && v == nums[i + 1]) return v;
            if (i + 2 < n && v == nums[i + 2]) return v;
            if (i + 3 < n && v == nums[i + 3]) return v;
        }
        return nums[0];
    }
}

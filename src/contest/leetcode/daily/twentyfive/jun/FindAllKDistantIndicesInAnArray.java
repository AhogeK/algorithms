package contest.leetcode.daily.twentyfive.jun;

import java.util.ArrayList;
import java.util.List;

/**
 * 2200. 找出数组中的所有 K 近邻下标
 *
 * @author AhogeK
 * @since 2025-06-24 19:31:40
 */
public class FindAllKDistantIndicesInAnArray {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int last = -k - 1;
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] == key) {
                last = i;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + k < nums.length && nums[i + k] == key) {
                last = i + k;
            }
            if (last >= i - k) ans.add(i);
        }
        return ans;
    }
}

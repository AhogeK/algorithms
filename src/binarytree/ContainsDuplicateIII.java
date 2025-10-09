package binarytree;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 * @author AhogeK
 * @since 2025-10-10 05:18:51
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long ceil = set.ceiling(num - valueDiff);
            if (ceil != null && ceil <= num + valueDiff) return true;
            set.add(num);
            if (i >= indexDiff) set.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}

package contest.leetcode.daily.twentyfive.july;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1865. 找出和为指定值的下标对
 *
 * @author AhogeK
 * @since 2025-07-06 15:50:12
 */
public class FindSumPairs {
    private final Map<Integer, Integer> map1 = new TreeMap<>();
    private final Map<Integer, Integer> map2 = new HashMap<>();
    private final int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) - 1);
        nums2[index] += val;
        map2.put(nums2[index], map2.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (entry.getKey() >= tot)
                break;
            if (map2.containsKey(tot - entry.getKey()))
                result += entry.getValue() * map2.get(tot - entry.getKey());
        }
        return result;
    }
}

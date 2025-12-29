package contest.leetcode.daily.twentyfive.nov;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-30 05:03:40
 */
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) x = (x + num) % p;
        if (x == 0) return 0;
        Map<Integer, Integer> map = HashMap.newHashMap(nums.length);
        map.put(0, -1);
        int y = 0;
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            y = (y + nums[i]) % p;
            int key = (y - x + p) % p;
            Integer index = map.get(key);
            if (index != null) {
                int len = i - index;
                if (len < minLen) minLen = len;
            }
            map.put(y, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}

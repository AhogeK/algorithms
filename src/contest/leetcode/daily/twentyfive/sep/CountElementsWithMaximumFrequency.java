package contest.leetcode.daily.twentyfive.sep;

/**
 * 3005. 最大频率元素计数
 *
 * @author AhogeK
 * @since 2025-09-22 13:30:17
 */
public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        int maxf = 0;
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > maxf) maxf = cnt[num];
        }
        int res = 0;
        for (int c : cnt)
            if (c == maxf)
                res += c;
        return res;
    }
}
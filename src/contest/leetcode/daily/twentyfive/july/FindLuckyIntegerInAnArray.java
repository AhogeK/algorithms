package contest.leetcode.daily.twentyfive.july;

/**
 * 1394. 找出数组中的幸运数
 *
 * @author AhogeK
 * @since 2025-07-05 07:52:05
 */
public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        int max = 0;
        for (int num : arr) {
            if (num > n) continue;
            if (num > max) max = num;
            cnt[num]++;
        }
        for (int i = max; i > 0; i--)
            if (cnt[i] == i) return i;
        return -1;
    }
}

package contest.leetcode.daily.twentyfive.dec;

/**
 * 3074. 重新分装苹果
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-24 06:18:11
 */
public class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int a : apple)
            total += a;

        int[] cnt = new int[51];
        for (int c : capacity)
            cnt[c]++;

        int used = 0;
        int sum = 0;

        for (int cap = 50; cap >= 1 && sum < total; cap--) {
            while (cnt[cap] > 0 && sum < total) {
                sum += cap;
                cnt[cap]--;
                used++;
            }
        }

        return used;
    }
}

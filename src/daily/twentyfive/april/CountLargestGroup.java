package daily.twentyfive.april;

/**
 * 1399. 统计最大组的数目
 *
 * @author AhogeK
 * @since 2025-04-23 09:20:57
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        // 最多四位数，数位和上限36（9+9+9+9=36）。开个够用的桶即可
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int x = i;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            count[sum]++;
        }
        // 统计最大组大小和最大组数量
        int max = 0, ans = 0;
        for (int i = 1; i <= 36; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = 1;
            } else if (count[i] == max) {
                ans++;
            }
        }
        return ans;
    }
}

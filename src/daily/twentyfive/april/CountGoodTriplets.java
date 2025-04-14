package daily.twentyfive.april;

/**
 * 1534. 统计好三元组
 *
 * @author AhogeK
 * @since 2025-04-14 08:13:39
 */
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // 提前检查 |arr[i] - arr[j]| <= a，如果不满足则跳过
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < arr.length; k++)
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) count++;
            }
        }
        return count;
    }
}

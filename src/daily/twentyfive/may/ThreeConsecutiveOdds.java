package daily.twentyfive.may;

/**
 * 1550. 存在连续三个奇数的数组
 *
 * @author AhogeK
 * @since 2025-05-12 00:26:53
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n - 3; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1)
                return true;
        }
        return false;
    }
}

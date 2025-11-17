package daily.twentyfive.nov;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-17 16:02:48
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev < k + 1) return false;
                prev = i;
            }
        }
        return true;
    }
}

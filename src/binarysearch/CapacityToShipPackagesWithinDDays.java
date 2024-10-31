package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/">
 * 「力扣」1011. 在 D 天内送达包裹的能力
 * </a>
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我买都会按给出重量（weights）的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-24 17:47:53
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }

            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int shipWithinDays2(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int currentDays = 1;
            int currentWeight = 0;
            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    currentDays++;
                    currentWeight = weight;

                    if (currentDays > days) break;
                } else {
                    currentWeight += weight;
                }
            }
            if (currentDays > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

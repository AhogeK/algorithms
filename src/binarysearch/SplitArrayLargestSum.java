package binarysearch;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum">「力扣」410. 分割数组的最大值</a>
 * <p>
 * 题目描述：给定一个非负整数数组 nums 和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-18 20:47:04
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 遍历数组找一个最大值，和所有元素的和
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 数组中元素最大值作为左边界，因为会被切分，所有m个子数组各自的最大值最小为max
        int left = max;
        int right = sum;
        while (left < right) {
            // 二分查找找一个可能的合的最大值
            int mid = left + (right - left) / 2;
            // 将数组以这个mid为切割点来切割，切多了那就意味着mid小了
            int splits = split(nums, mid);
            if (splits > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, int maxIntervalSum) {
        int splits = 1;
        int curIntervalSum = 0;
        for (int num : nums) {
            // 区间大于了区间最大值，分割数+1
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }

    public int splitArray2(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            boolean check = true;
            int count = 1;
            int sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    count++;
                    sum = num;
                    if (count > k) {
                        check = false;
                        break;
                    }
                } else {
                    sum += num;
                }
            }

            if (check) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

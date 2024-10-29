package binarysearch;

/**
 * 「力扣」第 4 题：寻找两个正序数组的中位数
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">题目网址</a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-04-25 13:12:56
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
         * 保证 nums1 是较短的数组
         * 在较短的数组中进行二分查找，可以减少时间复杂度
         */
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0;
        int imax = m;
        // halfLen 是两个数组合并后左半部分的长度 （向上取整）
        int halfLen = (m + n + 1) / 2;

        // 二分查找在 nums1 中的分割点
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            /*
             * 如果 nums1 的分割点 i 过小，则需要增大 i
             * i 需要在 nums1 的有效范围内
             * 当第二个数组的左半部分最大的值大于第一个数组的右半部分的最小值时，说明 i 作为分割点还能更大
             */
            if (i < m && nums2[j - 1] > nums1[i]) {
                imin = i + 1;
            }
            /*
             * 判断分割点i是否过大，目的是为了左半部分所有元素都可以小于等于右半的所有元素
             * i > 0 是为了确保 i - 1 不会越界
             * 当第一个数组的左半部分最大的值大于第二个数组的右半部分的最小值时，说明 i 作为分割点还能更小
             */
            else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            }
            // 找到了正确的分割点
            else {
                int maxOfLeft;
                // 计算左半部分的最大值
                if (i == 0) {
                    maxOfLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i - 1];
                } else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // 如果两个数组的总长度是奇数，返回左半部分的最大值作为中位数
                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                // 计算右半部分的最小值
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                // 如果两个数组的总长度是偶数，返回左半部分的最大值和右半部分的最小值的平均值作为中位数
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0.0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1LeftMax, nums2LeftMax) +
                            Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if (nums1LeftMax > nums2RightMin) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}

package sort.leetcode;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">「力扣」第 88 题：合并两个有序数组</a>
 *
 * @author AhogeK
 * @since 2025-02-28 16:22:07
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 初始化三个指针
        int p1 = m - 1; // nums1有效元素末尾
        int p2 = n - 1; // nums2末尾
        int p = m + n - 1; // nums1数组末尾

        // 从后往前填充 nums1
        while (p1 >= 0 && p2 >= 0) {
            // 取两个数组中较大的放在末尾
            if (nums1[p1] > nums2[p2]) nums1[p] = nums1[p1--];
            else nums1[p] = nums2[p2--];
            p--;
        }

        // 如果nums2还有剩余元素，需要复制到nums1中
        while (p2 >= 0) nums1[p--] = nums2[p2--];
    }
}

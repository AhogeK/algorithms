package sort.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AhogeK
 * @since 2025-03-06 17:10:33
 */
public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();

        int[] index = new int[len]; // 存储原始索引
        int[] temp = new int[len];  // 归并排序临时数组
        int[] ans = new int[len];   // 存储每个元素对应的计数结果

        // 初始化索引数组用于间接排序
        for (int i = 0; i < len; i++) index[i] = i;

        // 执行归并排序，同时统计计数
        mergeSorted(nums, 0, len - 1, temp, index, ans);

        for (int count : ans) res.add(count);
        return res;
    }

    private void mergeSorted(int[] nums, int left, int right, int[] temp, int[] index, int[] ans) {
        // 递归终止条件
        if (right == left) return;

        // 计算区间中点，分治处理
        int mid = left + (right - left) / 2;
        mergeSorted(nums, left, mid, temp, index, ans);
        mergeSorted(nums, mid + 1, right, temp, index, ans);

        // 如果区间已经有序，可以跳过合并
        // 比较左半部分最大值与右半部分最小值
        if (nums[index[mid]] <= nums[index[mid + 1]]) return; // 已经有序无序合并

        // 合并两个子区间，并统计右侧小于当前元素数量
        mergeArrays(nums, left, mid, right, temp, index, ans);
    }

    private void mergeArrays(int[] nums, int left, int mid, int right, int[] temp, int[] index, int[] ans) {
        // 复制索引数组到临时数组，用于合并过程
        System.arraycopy(index, left, temp, left, right - left + 1);

        int i = left; // 左子数组的当前处理位置
        int j = mid + 1; // 右子数组当前处理位置

        // 合并两个有序子数组
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                // 左子数组已处理完，直接取右子数组的元素
                index[k] = temp[j++];
            } else if (j > right) {
                // 右子数组已处理完，取左子数组的元素并更新计数
                index[k] = temp[i];
                // 右子数组全部元素已处理，且都合并到左侧元素之前
                // j 指向右子数组中下一个要处理的元素， mid + 1 表示右子数组起始，相减得到元素个数
                ans[temp[i]] += j - mid - 1;
                i++;
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 左子数组当前元素 <= 右子数组当前元素
                index[k] = temp[i];
                // 统计右子数组中已处理的元素个数（它们都小于当前元素）
                ans[temp[i]] += j - mid - 1;
                i++;
            } else {
                // 右子数组当前元素 < 左子数组当前元素
                index[k] = temp[j++];
                // 无需更新计数，因为我们只关心"右侧小于当前元素"的数量
            }
        }
    }
}

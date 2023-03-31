package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.common.SortingUtil;

/**
 * 归并排序测试
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-28 13:52:20
 */
class MergeSortTest {

    @Test
    void caseTest() {
        SortingUtil.testSortingAlgorithms(new MergeSort(), 10_000);
    }

    @Test
    void caseTest2() {
        /*
            利用归并排序的逻辑，将一个整数数据中的元素向右轮转k个位置，其中k是整数
         */
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int len = nums.length;
        int[] temp = new int[len];
        System.arraycopy(nums, 0, temp, 0, len);
        mergeOfTwoArray(temp, 0, len - k - 1, len - 1);
        Assertions.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, temp);
    }

    private void mergeOfTwoArray(int[] temp, int left, int mid, int right) {
        int[] nums = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= right) {
            nums[k++] = temp[j++];
        }
        System.arraycopy(nums, 0, temp, left, nums.length);
    }
}

package sort;

import sort.common.ISortingAlgorithm;
import sort.common.SortingUtil;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 18:19:51
 */
public class InsertionSort implements ISortingAlgorithm {

    /**
     * 一个一个向前交换
     */
    @Override
    public void sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
    }

    /**
     * 逐个向后赋值
     */
    public int[] sortArray2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                // 无需交换减少赋值次数
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    /**
     * 哨兵模式的插入算法
     */
    public int[] sortArray3(int[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        swap(nums, 0, minIndex);
        for (int i = 2; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 1 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        SortingUtil.swap(nums, a, b);
    }

    /**
     * 二分插入排序
     */
    public int[] sortArray4(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            // 使用二分查找查找插入的位置
            int j = Math.abs(Arrays.binarySearch(nums, 0, i, temp) + 1);
            // 将数组向右移动一个位置
            System.arraycopy(nums, j, nums, j + 1, i - j);
            // 将元素放置在其正确的位置上
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 二分插入排序
     * 向后逐个赋值法
     */
    public int[] sortArray5(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;

            int loc = binarySearch(nums, temp, 0, j);

            while (j >= loc) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid])
                return mid + 1;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
}

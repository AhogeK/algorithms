package sort.leetcode.select;

import sort.common.ISortingAlgorithm;

/**
 * 使用冒泡排序完成 「力扣」912. 排序数组
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-29 20:55:40
 */
public class BubbleSort implements ISortingAlgorithm {

    @Override
    public void sortArray(int[] nums) {
        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    /**
     * while版但不如双for循环版，双for版循环的次数更少
     */
    public int[] sortArray2(int[] nums) {
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    flag = true;
                }
            }
        }

        return nums;
    }

    /**
     * 双向冒泡（鸡尾酒排序）版本
     */
    public int[] sortArray3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // 从左到右
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;

            swapped = false;
            right--;

            // 从右到左
            for (int i = right; i > left; i--) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    swapped = true;
                }
            }

            left++;
        }
        return nums;
    }
}

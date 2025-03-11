package sort;

import sort.common.ISortingAlgorithm;

import java.util.Random;

import static sort.common.SortingUtil.swap;

/**
 * @author AhogeK
 * @since 2025-03-10 21:00:31
 */
public class TwoWayQuickSort implements ISortingAlgorithm {

    private static final Random RANDOM = new Random();

    @Override
    public void sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);

        // 循环不变量
        // all in [left + 1, le) <= pivot
        // all in (ge, right] >= pivot
        // le > ge 的时候终止
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            // 注意：这里一定是 nums[le] < pivot，等于 pivot 的元素是被交换过来得到的
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            // 此时 le 来到第1个大于等于 pivot 的位置
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            // 此时 ge 来到第一个小于等于 pivot 的位置
            if (le > ge) {
                break;
            }

            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }
}

package sort;

import sort.common.ISortingAlgorithm;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 快速排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 16:37:42
 */
public class Quicksort implements ISortingAlgorithm {

    private static final Random RANDOM;

    static {
        try {
            RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (r <= l) return;
        int q = partition(nums, l, r);
        quickSort(nums, l, q - 1);
        quickSort(nums, q + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int p = RANDOM.nextInt(r - l + 1) + l;
        swap(nums, p, r);
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

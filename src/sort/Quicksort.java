package sort;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 快速排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 16:37:42
 */
public class Quicksort {

    public int[] sortArray(int[] nums) throws NoSuchAlgorithmException {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) throws NoSuchAlgorithmException {
        if (r <= l) return;
        int q = partition(nums, l, r);
        quickSort(nums, l, q - 1);
        quickSort(nums, q + 1, r);
    }

    private int partition(int[] nums, int l, int r) throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        int p = random.nextInt(r - l + 1) + l;
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

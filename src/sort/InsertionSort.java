package sort;

/**
 * 插入排序
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-01 18:19:51
 */
public class InsertionSort {

    /**
     * 一个一个向前交换
     */
    public int[] sortArray1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(nums, j, j - 1);
                j--;
            }
        }
        return nums;
    }

    /**
     * 逐个向后赋值
     */
    public int[] sortArray2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                // 无需交换减少赋值次数
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
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
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

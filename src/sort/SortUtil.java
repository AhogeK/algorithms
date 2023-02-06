package sort;

/**
 * 排序工具类
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-02-06 18:21:10
 */
public class SortUtil {

    private SortUtil() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * 交换数组中的两个索引位置的元素
     *
     * @param nums   数组
     * @param index1 索引1
     * @param index2 索引2
     */
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void printArray(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

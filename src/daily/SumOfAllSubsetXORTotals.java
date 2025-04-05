package daily;

/**
 * @author AhogeK
 * @since 2025-04-05 13:22:09
 */
public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int currentXOR) {
        // 已处理完所有元素，返回当前子集的异或总值
        if (index == nums.length) return currentXOR;

        // 不选择当前元素
        int sumWithout = backtrack(nums, index + 1, currentXOR);

        // 选择当前元素
        int sumWith = backtrack(nums, index + 1, currentXOR ^ nums[index]);

        return sumWithout + sumWith;
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals solution = new SumOfAllSubsetXORTotals();
        System.out.println(solution.subsetXORSum(new int[]{1, 3}));
        System.out.println(solution.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }
}

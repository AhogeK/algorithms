package daily.twentyfive.april;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-i>2873. 有序三元组中的最大值 I</a>
 *
 * @author AhogeK
 * @since 2025-04-02 17:17:58
 */
public class MaximumValueOfAnOrderedTripletI {

    public long maximumTripletValue(int[] nums) {
        long maxTripletValue = 0; // 存储最终答案
        int maxI = 0; // 表示当前位置之前的最大元素
        int maxDiff = 0; // 表示当前位置之前所有 i < j 对中 nums[i] - nums[j] 的最大值

        for (int k = 0; k < nums.length; k++) {
            // 对于当前位置 k，计算可能的最大三元组值
            maxTripletValue = Math.max(maxTripletValue, (long) maxDiff * nums[k]);

            // 更新 maxDiff，考虑当前位置作为 j 计算 (nums[i] - nums[j]) 的差值
            maxDiff = Math.max(maxDiff, maxI - nums[k]);

            // 更新 maxI 考虑当前位置作为 i
            maxI = Math.max(maxI, nums[k]);
        }

        return maxTripletValue;
    }

    public static void main(String[] args) {
        int[] nums = {12, 6, 1, 2, 7};
        MaximumValueOfAnOrderedTripletI maximumValueOfAnOrderedTripletI = new MaximumValueOfAnOrderedTripletI();
        long maxTripletValue = maximumValueOfAnOrderedTripletI.maximumTripletValue(nums);
        System.out.println(maxTripletValue);
    }
}

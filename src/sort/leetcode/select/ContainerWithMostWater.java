package sort.leetcode.select;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water">
 * 11. 盛最多水的容器 (双指针)
 * </a>
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2023-06-28 14:27:53
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }

    /**
     * 用于学习，使用选择排序知识解题
     */
    public int maxArea2(int[] height) {
        int n = height.length;
        int maxWater = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxAreaIndex = i + 1;
            for (int j = i + 1; j < n; j++) {
                int currentArea = Math.min(height[i], height[j]) * (j - i);
                int maxIndexArea = Math.min(height[i], height[maxAreaIndex]) * (maxAreaIndex - i);
                if (currentArea > maxIndexArea) maxAreaIndex = j;
            }

            int area = Math.min(height[i], height[maxAreaIndex]) * (maxAreaIndex - i);
            maxWater = Math.max(maxWater, area);
        }

        return maxWater;
    }
}

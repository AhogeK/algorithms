package array;

/**
 * @author AhogeK
 * @since 2025-04-04 02:24:18
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }
}

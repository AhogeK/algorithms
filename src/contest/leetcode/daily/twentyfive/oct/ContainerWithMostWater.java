package contest.leetcode.daily.twentyfive.oct;

/**
 * 11. 盛最多水的容器
 *
 * @author AhogeK
 * @since 2025-10-04 20:50:30
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;
        while (l < r) {
            int hl = height[l], hr = height[r];
            int area;
            if (hl < hr) {
                area = hl * (r - l);
                l++;
            } else {
                area = hr * (r - l);
                r--;
            }
            if (area > ans)
                ans = area;
        }
        return ans;
    }
}

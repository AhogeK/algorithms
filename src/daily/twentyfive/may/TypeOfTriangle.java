package daily.twentyfive.may;

/**
 * 3024. 三角形类型
 *
 * @author AhogeK
 * @since 2025-05-19 16:22:24
 */
public class TypeOfTriangle {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b <= c || a + c <= b || b + c <= a)
            return "none";
        if (a == b && b == c)
            return "equilateral";
        if (a == b || b == c || a == c)
            return "isosceles";
        return "scalene";
    }
}

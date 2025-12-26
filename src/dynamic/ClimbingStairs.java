package dynamic;

/**
 * 70. 爬楼梯
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-26 11:46:29
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

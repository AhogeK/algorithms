package daily.twentyfive.aug;

/**
 * 342. 4的幂
 *
 * @author AhogeK
 * @since 2025-08-15 03:47:52
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}

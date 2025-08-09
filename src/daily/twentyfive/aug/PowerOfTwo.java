package daily.twentyfive.aug;

/**
 * 231. 2 的幂
 *
 * @author AhogeK
 * @since 2025-08-10 03:26:14
 */
public class PowerOfTwo {
    static final int BIG = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }
}

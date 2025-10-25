package daily.twentyfive.oct;

/**
 * 1716. 计算力扣银行的钱
 *
 * @author AhogeK
 * @since 2025-10-25 20:35:35
 */
public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int w = n / 7;
        int d = n % 7;
        return (7 * w * (w + 7) + d * (d + 2 * w + 1)) >> 1;
    }
}

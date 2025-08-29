package daily.twentyfive.aug;

/**
 * 3021. Alice 和 Bob 玩鲜花游
 *
 * @author AhogeK
 * @since 2025-08-29 21:01:47
 */
public class AliceAndBobPlayingFlowerGame {
    public long flowerGame(int n, int m) {
        long oddX = (n + 1) / 2;
        long evenX = n / 2;
        long oddY = (m + 1) / 2;
        long evenY = m / 2;
        return oddX * evenY + evenX * oddY;
    }
}

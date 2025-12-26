package daily.twentyfive.dec;

/**
 * 2483. 商店的最少代价
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-26 11:03:24
 */
public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        final int n = customers.length();
        final char[] s = customers.toCharArray();
        int penalty = 0;
        for (char c : s)
            if (c == 'Y') penalty++;
        int bestPenalty = penalty;
        int bestTime = 0;
        for (int j = 0; j < n; j++) {
            final char c = s[j];
            if (c == 'Y') penalty -= 1;
            else penalty += 1;
            final int candidateTime = j + 1;
            if (penalty < bestPenalty) {
                bestPenalty = penalty;
                bestTime = candidateTime;
            }
        }
        return bestTime;
    }
}

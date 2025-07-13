package daily.twentyfive.july;

import java.util.Arrays;

/**
 * 2410. 运动员和训练师的最大匹配数
 *
 * @author AhogeK
 * @since 2025-07-13 15:35:53
 */
public class MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        int n = players.length;
        int m = trainers.length;
        int ans = 0;
        while (i < n && j < m) {
            if (players[i] <= trainers[j]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }
}

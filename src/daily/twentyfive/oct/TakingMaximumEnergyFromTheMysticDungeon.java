package daily.twentyfive.oct;

/**
 * 3147. 从魔法师身上吸取的最大能量
 *
 * @author AhogeK
 * @since 2025-10-10 04:49:21
 */
public class TakingMaximumEnergyFromTheMysticDungeon {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int i = n - 1; i >= n - k; i--) {
            ans = Math.max(ans, energy[i]);
        }
        for (int i = n - k - 1; i >= 0; i--) {
            energy[i] += energy[i + k];
            ans = Math.max(ans, energy[i]);
        }
        return ans;
    }
}

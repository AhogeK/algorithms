package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 排列序列
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-28 08:51:42
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i - 1] * i;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            k %= factorial[i];
            sb.append(nums.get(index));
            nums.remove(index);
        }
        return sb.toString();
    }
}

package contest.leetcode.daily.twentyfive.may;

import java.util.List;

/**
 * 3337. 字符串转换后的长度 II
 *
 * @author AhogeK
 * @since 2025-05-15 09:47:06
 */
public class TotalCharactersInStringAfterTransformationsII {

    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // 1. 初始统计各字母出现次数
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // 2. 构建字母转移矩阵 dp[i][j]: i字母能转到j字母的次数（0/1，多用于nums[i]>1时回绕）
        long[][] dp = new long[26][26];
        for (int i = 0; i < 26; i++) {
            int cnt = nums.get(i);
            for (int k = 1; k <= cnt; k++) {
                int j = (i + k) % 26;
                dp[i][j]++;
            }
        }

        // 3. 矩阵快速幂+向量变换
        long[] vec = count; // 初始向量
        long[][] mat = dp; // 初始矩阵
        for (int p = t; p > 0; p >>= 1) {
            if ((p & 1) != 0) {
                // vec = vec * mat
                long[] nextVec = new long[26];
                for (int i = 0; i < 26; i++) {
                    if (vec[i] == 0)
                        continue;
                    for (int j = 0; j < 26; j++) {
                        nextVec[j] = (nextVec[j] + vec[i] * mat[i][j]) % MOD;
                    }
                }
                vec = nextVec;
            }
            // mat = mat * mat
            long[][] nextMat = new long[26][26];
            for (int i = 0; i < 26; i++) {
                for (int k = 0; k < 26; k++) {
                    if (mat[i][k] == 0)
                        continue;
                    for (int j = 0; j < 26; j++) {
                        nextMat[i][j] = (nextMat[i][j] + mat[i][k] * mat[k][j]) % MOD;
                    }
                }
            }
            mat = nextMat;
        }

        // 4. 统计总长
        long res = 0;
        for (long v : vec)
            res = (res + v) % MOD;
        return (int) res;
    }
}

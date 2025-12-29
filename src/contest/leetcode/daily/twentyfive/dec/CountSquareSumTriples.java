package contest.leetcode.daily.twentyfive.dec;

/**
 * 1925. 统计平方和三元组的数目
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-08 13:35:53
 */
public class CountSquareSumTriples {
    public int countTriples(int n) {
        boolean[] isSquare = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) isSquare[i * i] = true;
        int count = 0;
        for (int c = 1; c <= n; c++) {
            int cSq = c * c;
            for (int a = 1; a < c; a++) {
                int diff = cSq - a * a;
                if (isSquare[diff]) count++;
            }
        }
        return count;
    }
}

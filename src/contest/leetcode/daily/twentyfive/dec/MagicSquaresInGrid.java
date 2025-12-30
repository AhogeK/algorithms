package contest.leetcode.daily.twentyfive.dec;

/**
 * 840. 矩阵中的幻方
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-30 11:06:32
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (r < 3 || c < 3) return 0;
        int ans = 0;
        for (int i = 0; i + 2 < r; i++) {
            for (int j = 0; j + 2 < c; j++) {
                if (isMagic3x3(grid, i, j)) ans++;
            }
        }
        return ans;
    }

    private boolean isMagic3x3(int[][] grid, int i, int j) {
        if (grid[i + 1][j + 1] != 5) return false;
        if (grid[i][j] % 2 != 0) return false;
        int[][] dir = {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}};
        long s = 0;
        for (int[] d : dir) s = s * 10 + grid[i + d[0]][j + d[1]];
        return (s == 81672943L || s == 67294381L || s == 29438167L || s == 43816729L ||
                s == 83492761L || s == 61834927L || s == 27618349L || s == 49276183L);
    }
}

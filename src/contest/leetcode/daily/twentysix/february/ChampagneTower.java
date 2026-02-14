package contest.leetcode.daily.twentysix.february;

/**
 * 799. 香槟塔
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-14 19:29:00
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[query_row + 2];
        row[0] = poured;
        for (int i = 0; i < query_row; i++) {
            double[] nextRow = new double[query_row + 2];
            for (int j = 0; j <= i; j++) {
                double flow = row[j];
                if (flow > 1) {
                    double overflow = (flow - 1) / 2.0;
                    nextRow[j] += overflow;
                    nextRow[j + 1] += overflow;
                }
            }
            row = nextRow;
        }
        return Math.min(1.0, row[query_glass]);
    }
}

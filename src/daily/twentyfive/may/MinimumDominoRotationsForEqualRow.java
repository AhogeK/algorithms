package daily.twentyfive.may;

/**
 * 1007. 行相等的最少多米诺旋转
 *
 * @author AhogeK
 * @since 2025-05-03 16:39:21
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = check(tops[0], tops, bottoms);
        if (ans != -1 || tops[0] == bottoms[0]) return ans;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            if (tops[i] != target && bottoms[i] != target) return -1;
            else if (tops[i] != target) rotateTop++;
            else if (bottoms[i] != target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }
}

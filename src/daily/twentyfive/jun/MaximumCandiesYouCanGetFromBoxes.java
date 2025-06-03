package daily.twentyfive.jun;

/**
 * 1298. 你能从盒子里获得的最大糖果数
 *
 * @author AhogeK
 * @since 2025-06-03 19:55:45
 */
public class MaximumCandiesYouCanGetFromBoxes {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] canOpen = new boolean[n], hasBox = new boolean[n], used = new boolean[n];
        for (int i = 0; i < n; i++)
            canOpen[i] = (status[i] == 1);

        int[] queue = new int[n];
        int l = 0, r = 0;
        for (int b : initialBoxes) {
            hasBox[b] = true;
            if (canOpen[b]) {
                queue[r++] = b;
                used[b] = true;
            }
        }
        int ans = 0;
        while (l < r) {
            int x = queue[l++];
            ans += candies[x];
            r = getR(keys, canOpen, hasBox, used, queue, r, x);
            r = getR(containedBoxes, hasBox, canOpen, used, queue, r, x);
        }
        return ans;
    }

    private int getR(int[][] keys, boolean[] canOpen, boolean[] hasBox, boolean[] used, int[] queue, int r, int x) {
        for (int y : keys[x]) {
            if (!canOpen[y]) {
                canOpen[y] = true;
                if (hasBox[y] && !used[y]) {
                    queue[r++] = y;
                    used[y] = true;
                }
            }
        }
        return r;
    }
}

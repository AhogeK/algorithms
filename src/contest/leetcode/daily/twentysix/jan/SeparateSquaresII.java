package contest.leetcode.daily.twentysix.jan;

import java.util.Arrays;

/**
 * 3454. 分割正方形 II
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-14 21:15:39
 */
public class SeparateSquaresII {
    private int[] treeCount;
    private long[] treeActiveLen;
    private int[] treeMaxLen;

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        int[] xRaw = new int[n << 1];
        int xIdx = 0;
        for (int[] sq : squares) {
            xRaw[xIdx++] = sq[0];
            xRaw[xIdx++] = sq[0] + sq[2];
        }
        Arrays.sort(xRaw);

        int m = 0;
        for (int i = 0; i < xRaw.length; i++) {
            if (i == 0 || xRaw[i] != xRaw[i - 1]) {
                xRaw[m++] = xRaw[i];
            }
        }

        int numEvents = n << 1;
        int[] evX1 = new int[numEvents];
        int[] evX2 = new int[numEvents];
        int[] evType = new int[numEvents];
        long[] evSortKey = new long[numEvents];

        int ePtr = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            int idx1 = binarySearch(xRaw, m, sq[0]);
            int idx2 = binarySearch(xRaw, m, sq[0] + l);

            evX1[ePtr] = idx1;
            evX2[ePtr] = idx2;
            evType[ePtr] = 1;
            evSortKey[ePtr] = ((long) y << 32) | ePtr;
            ePtr++;

            evX1[ePtr] = idx1;
            evX2[ePtr] = idx2;
            evType[ePtr] = -1;
            evSortKey[ePtr] = ((long) (y + l) << 32) | ePtr;
            ePtr++;
        }

        Arrays.sort(evSortKey);

        int treeSize = 4 * m;
        if (treeCount == null || treeCount.length < treeSize) {
            treeCount = new int[treeSize];
            treeActiveLen = new long[treeSize];
            treeMaxLen = new int[treeSize];
        } else {
            Arrays.fill(treeCount, 0, treeSize, 0);
            Arrays.fill(treeActiveLen, 0, treeSize, 0);
        }

        buildTree(1, 0, m - 2, xRaw); // 这里的 m-2 是因为区间索引是 0 到 m-2

        long totalArea = 0;
        int prevY = (int) (evSortKey[0] >>> 32);

        for (int i = 0; i < numEvents; ) {
            int curY = (int) (evSortKey[i] >>> 32);

            if (curY > prevY) {
                totalArea += (curY - prevY) * treeActiveLen[1];
            }

            while (i < numEvents && (int) (evSortKey[i] >>> 32) == curY) {
                int originalIdx = (int) evSortKey[i];
                update(1, 0, m - 2, evX1[originalIdx], evX2[originalIdx] - 1, evType[originalIdx]);
                i++;
            }
            prevY = curY;
        }

        Arrays.fill(treeCount, 0, treeSize, 0);
        Arrays.fill(treeActiveLen, 0, treeSize, 0);

        double target = totalArea / 2.0;
        double currentTotal = 0;
        prevY = (int) (evSortKey[0] >>> 32);

        for (int i = 0; i < numEvents; ) {
            int curY = (int) (evSortKey[i] >>> 32);
            long width = treeActiveLen[1];

            if (curY > prevY) {
                double diff = (double) (curY - prevY) * width;
                if (currentTotal + diff >= target) {
                    return prevY + (target - currentTotal) / width;
                }
                currentTotal += diff;
            }

            while (i < numEvents && (int) (evSortKey[i] >>> 32) == curY) {
                int originalIdx = (int) evSortKey[i];
                update(1, 0, m - 2, evX1[originalIdx], evX2[originalIdx] - 1, evType[originalIdx]);
                i++;
            }
            prevY = curY;
        }

        return prevY;
    }

    private int binarySearch(int[] arr, int len, int val) {
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < val)
                l = mid + 1;
            else if (arr[mid] > val)
                r = mid - 1;
            else
                return mid;
        }
        return l;
    }

    private void buildTree(int node, int start, int end, int[] xRaw) {
        if (start == end) {
            treeMaxLen[node] = xRaw[start + 1] - xRaw[start];
            return;
        }
        int mid = (start + end) >>> 1;
        buildTree(node << 1, start, mid, xRaw);
        buildTree(node << 1 | 1, mid + 1, end, xRaw);
        treeMaxLen[node] = treeMaxLen[node << 1] + treeMaxLen[node << 1 | 1];
    }

    private void update(int node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            treeCount[node] += val;
            pushUp(node, start, end);
            return;
        }
        int mid = (start + end) >>> 1;
        if (l <= mid)
            update(node << 1, start, mid, l, r, val);
        if (r > mid)
            update(node << 1 | 1, mid + 1, end, l, r, val);
        pushUp(node, start, end);
    }

    private void pushUp(int node, int start, int end) {
        if (treeCount[node] > 0) {
            treeActiveLen[node] = treeMaxLen[node];
        } else if (start == end) {
            treeActiveLen[node] = 0;
        } else {
            treeActiveLen[node] = treeActiveLen[node << 1] + treeActiveLen[node << 1 | 1];
        }
    }
}

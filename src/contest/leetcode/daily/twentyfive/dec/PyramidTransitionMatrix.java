package contest.leetcode.daily.twentyfive.dec;

import java.util.List;

/**
 * 756. 金字塔转换矩阵
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-29 08:50:26
 */
public class PyramidTransitionMatrix {
    private final int[][] trans = new int[6][6];
    private final byte[] memo = new byte[1 << 21];

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            int c = s.charAt(2) - 'A';
            trans[a][b] |= 1 << c;
        }
        int start = encode(bottom);
        return dfs(start);
    }

    private boolean dfs(int code) {
        byte m = memo[code];
        if (m != 0) return m == 2;
        int len = code >>> 18;
        if (len == 1) {
            memo[code] = 2;
            return true;
        }
        for (int i = 0; i < len - 1; i++) {
            int a = get(code, i);
            int b = get(code, i + 1);
            if (trans[a][b] == 0) {
                memo[code] = 1;
                return false;
            }
        }
        int nextLen = len - 1;
        boolean ok = buildNextAndDfs(code, nextLen, 0, 0);
        memo[code] = (byte) (ok ? 2 : 1);
        return ok;
    }

    private boolean buildNextAndDfs(int code, int nextLen, int pos, int nextPacked) {
        if (pos == nextLen) {
            int nextCode = (nextLen << 18) | nextPacked;
            return dfs(nextCode);
        }
        int a = get(code, pos);
        int b = get(code, pos + 1);
        int mask = trans[a][b];
        while (mask != 0) {
            int low = mask & -mask;
            int c = Integer.numberOfTrailingZeros(low);
            int packed = nextPacked | (c << (pos * 3));
            if (buildNextAndDfs(code, nextLen, pos + 1, packed)) return true;
            mask -= low;
        }
        return false;
    }

    private int get(int code, int i) {
        return (code >>> (i * 3)) & 7;
    }

    private int encode(String s) {
        int len = s.length();
        int packed = 0;
        for (int i = 0; i < len; i++) {
            int v = s.charAt(i) - 'A';
            packed |= v << (i * 3);
        }
        return (len << 18) | packed;
    }
}

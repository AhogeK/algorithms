package contest.nowcoder.daily.twentysix;

import java.io.IOException;
import java.io.InputStream;

/**
 * 华华给月月准备礼物
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-02 18:56:40
 */
public class HuahuaGivesGiftToYueyue {
    private static boolean canCut(int[] lengths, long k, long x) {
        long cnt = 0;
        for (int v : lengths) {
            cnt += (v / x);
            if (cnt >= k) return true; // 够了就提前结束，省时间
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        while (true) {
            long nVal = fs.nextLong();
            if (nVal == Long.MIN_VALUE) break; // EOF
            long k = fs.nextLong();
            int n = (int) nVal;

            int[] a = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                int v = (int) fs.nextLong();
                a[i] = v;
                if (v > max) max = v;
            }

            if (max == 0) {
                out.append(0).append('\n');
                continue;
            }

            long lo = 1, hi = max, ans = 0;
            while (lo <= hi) {
                long mid = (lo + hi) >>> 1;
                if (canCut(a, k, mid)) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Long.MIN_VALUE; // EOF
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}

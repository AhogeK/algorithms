package contest.nowcoder.daily.twentyfive.dec;

import java.io.*;

/**
 * 小红的01子序列构造
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-29 17:05:32
 */
public class BinarySubsequenceBuilder {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = (int) fs.nextLong();
        long k = fs.nextLong();
        char[] s = fs.next().toCharArray();

        long pairs = 0;
        int zeros = 0, ones = 0;
        int r = 0;

        for (int l = 1; l <= n; l++) {
            while (r < n && pairs < k) {
                char c = s[r];
                r++;
                if (c == '0') {
                    zeros++;
                } else {
                    pairs += zeros;
                    ones++;
                }
            }

            if (pairs == k) {
                out.println(l + " " + r);
                out.flush();
                return;
            }

            char left = s[l - 1];
            if (left == '0') {
                pairs -= ones;
                zeros--;
            } else {
                ones--;
            }
        }

        out.println("-1");
        out.flush();
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
                if (c == -1) return Long.MIN_VALUE;
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

        String next() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return null;
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }
}

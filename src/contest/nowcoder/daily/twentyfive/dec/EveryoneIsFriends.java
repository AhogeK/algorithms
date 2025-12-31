package contest.nowcoder.daily.twentyfive.dec;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 人人都是好朋友
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-30 14:46:00
 */
public class EveryoneIsFriends {
    public static void main(String[] args) {

    }

    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        public FastScanner(InputStream in) {
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

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Integer.MIN_VALUE;
            } while (c <= ' ');
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c =readByte();
            }
            int x = 0;
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = readByte();
            }
            return x * sign;
        }
    }

    static final class XorDSU {
        int[] parent;
        int[] size;
        int[] xr;
        int n;

        XorDSU(int cap) {
            parent = new int[Math.max(1, cap)];
            size = new int[Math.max(1, cap)];
            xr = new int[Math.max(1, cap)];
            n = 0;
        }

        int addNode() {
            if (n == parent.length) grow();
            parent[n] = n;
            size[n] = 1;
            xr[n] = 0;
            return n++;
        }

        private void grow() {
            int newCap = parent.length << 1;
            parent = Arrays.copyOf(parent, newCap);
            size = Arrays.copyOf(size, newCap);
            xr = Arrays.copyOf(xr, newCap);
        }

        int find(int x) {
            if (parent[x] == x) return x;
            int p = parent[x];
            int r = find(p);
            xr[x] ^= xr[p];
            parent[x] = r;
            return r;
        }
    }
}

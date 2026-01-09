package contest.nowcoder.daily.twentyfive.dec;

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
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int n = fs.nextInt();

            // At most 2n unique IDs
            XorDSU dsu = new XorDSU(Math.max(1, 2 * n));
            IntIntMap map = new IntIntMap(Math.max(4, 2 * n), dsu);

            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int a = fs.nextInt();
                int b = fs.nextInt();
                int c = fs.nextInt();

                if (!ok) continue;

                int ia = map.getOrCreate(a);
                int ib = map.getOrCreate(b);
                int w = (c == 1) ? 0 : 1;

                if (!dsu.union(ia, ib, w)) ok = false;
            }

            out.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(out);
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
                c = readByte();
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

        boolean union(int a, int b, int w) {
            int ra = find(a);
            int rb = find(b);
            int xa = xr[a];
            int xb = xr[b];
            if (ra == rb) return (xa ^ xb) == w;
            if (size[ra] > size[rb]) {
                int tmp = ra;
                ra = rb;
                rb = tmp;
                tmp = xa;
                xa = xb;
                xb = tmp;
            }

            parent[ra] = rb;
            xr[ra] = xa ^ xb ^ w;
            size[rb] += size[ra];
            return true;
        }
    }

    static final class IntIntMap {
        final XorDSU dsu;
        int[] keys;
        int[] vals;
        int mask;
        int size;

        IntIntMap(int expectedKeys, XorDSU dsu) {
            int cap = 1;
            int need = (int) (expectedKeys / 0.7f) + 1;
            while (cap < need) cap <<= 1;
            keys = new int[cap];
            vals = new int[cap];
            mask = cap - 1;
            size = 0;
            this.dsu = dsu;
        }

        private static int mix(int x) {
            x *= 0x9E3779B9;
            return x ^ (x >>> 16);
        }

        int getOrCreate(int key) {
            int i = mix(key) & mask;
            while (true) {
                int k = keys[i];
                if (k == 0) {
                    keys[i] = key;
                    int idx = dsu.addNode();
                    vals[i] = idx + 1;
                    size++;
                    return idx;
                }
                if (k == key) return vals[i] - 1;
                i = (i + 1) & mask;
            }
        }
    }
}

package contest.nowcoder.daily.twentysix.february.sixth;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <a href="https://www.nowcoder.com/practice/9bb882504d574ec287f69e967ce0fb95?channelPut=tracker2">【模板】巴什博弈</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-06 22:08:30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        BufferedOutputStream out = new BufferedOutputStream(System.out, 1 << 20);

        final byte[] YES = new byte[]{'Y', 'E', 'S', '\n'};
        final byte[] NO = new byte[]{'N', 'O', '\n'};

        final int T = fs.nextInt();
        for (int i = 0; i < T; i++) {
            long n = fs.nextLong();
            long m = fs.nextLong();
            long mod = n % (m + 1);
            if (mod == 0) out.write(NO);
            else out.write(YES);
        }
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
            } while (c <= 32);
            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return sign * val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}

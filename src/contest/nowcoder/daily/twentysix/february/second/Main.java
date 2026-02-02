package contest.nowcoder.daily.twentysix.february.second;

import java.io.IOException;
import java.io.InputStream;

/**
 * 躲藏
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-02 19:48:04
 */
public class Main {
    private static final long MOD = 2000120420010122L;

    public static void main(String[] args) throws IOException {
        FastInput fi = new FastInput(System.in);
        StringBuilder out = new StringBuilder(1 << 20);

        long cCnt = 0, cwCnt = 0, cwbCnt = 0, ans = 0;
        boolean hasCharInLine = false;

        for (; ; ) {
            int b = fi.readByte();
            if (b == -1) break;

            if (b == '\r') continue;

            if (b == '\n') {
                out.append(ans).append('\n');
                cCnt = cwCnt = cwbCnt = ans = 0;
                hasCharInLine = false;
                continue;
            }

            hasCharInLine = true;

            int ch = b;
            if (ch >= 'A' && ch <= 'Z') ch |= 32;

            if (ch == 'c') {
                ans += cwbCnt;
                if (ans >= MOD) ans -= MOD;

                cCnt++;
                if (cCnt >= MOD) cCnt -= MOD;
            } else if (ch == 'w') {
                cwCnt += cCnt;
                if (cwCnt >= MOD) cwCnt -= MOD;
            } else if (ch == 'b') {
                cwbCnt += cwCnt;
                if (cwbCnt >= MOD) cwbCnt -= MOD;
            }
        }

        if (hasCharInLine) out.append(ans).append('\n');

        System.out.println(out);
    }

    private static final class FastInput {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        public FastInput(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++] & 0xff;
        }
    }
}

package contest.nowcoder.daily.twentysix.february.twentythird;

import java.io.IOException;
import java.io.InputStream;

/**
 * <a href="https://www.nowcoder.com/practice/96e8db05848142808e69d04d604f2dd8?channelPut=tracker2">小红统计区间（easy）</a>
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-02-23 17:08:32
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        long totalValidSubarrays = 0;
        long currentSum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            while (currentSum >= k) {
                totalValidSubarrays += (n - right);
                currentSum -= nums[left++];
            }
        }
        System.out.println(totalValidSubarrays);
    }

    static class FastReader {
       private final InputStream in;
       private final byte[] buffer = new byte[1 << 16];
       private int head = 0, tail = 0;

       public FastReader(InputStream in) {
           this.in = in;
       }

       private int read() throws IOException {
           if (head >= tail) {
               head = 0;
               tail = in.read(buffer, 0, buffer.length);
               if (tail <= 0) return -1;
           }
           return buffer[head++];
       }

       public int nextInt() throws IOException {
           int c = read();
           while (c <= 32) {
               if (c == -1) return -1;
               c = read();
           }
           int res = 0;
           while (c > 32) {
               res = res * 10 + c - '0';
               c = read();
           }
           return res;
       }

       public long nextLong() throws IOException {
           int c = read();
           while (c <= 32) {
               if (c == -1) return -1;
               c = read();
           }
           long res = 0;
           while (c > 32) {
               res = res * 10 + c - '0';
               c = read();
           }
           return res;
       }
    }
}

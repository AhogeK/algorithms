package daily.twentyfive.dec;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2402. 会议室 III
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-27 09:21:46
 */
public class MeetingRoomsIII {
    private static final int SHIFT = 7;
    private static final long MASK = (1L << SHIFT) - 1;

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        var free = new IntMinHeap(n);
        for (int i = 0; i < n; i++) free.push(i);
        var busy = new LongMinHeap(n);
        int[] cnt = new int[n];
        for (int[] mt : meetings) {
            long start = mt[0];
            long end = mt[1];
            long dur = end - start;
            while (!busy.isEmpty() && unpackEnd(busy.peek()) <= start) {
                long key = busy.pop();
                free.push(unpackRoom(key));
            }
            int room;
            long realEnd;
            if (!free.isEmpty()) {
                room = free.pop();
                realEnd = end;
            } else {
                long key = busy.pop();
                long earliestEnd = unpackEnd(key);
                room = unpackRoom(key);
                realEnd = earliestEnd + dur;
            }
            cnt[room]++;
            busy.push(pack(realEnd, room));
        }
        int bestRoom = 0;
        for (int i = 1; i < n; i++)
            if (cnt[i] > cnt[bestRoom]) bestRoom = i;
        return bestRoom;
    }

    private long pack(long endTime, int room) {
        return (endTime << SHIFT) | room;
    }

    private int unpackRoom(long key) {
        return (int) (key & MASK);
    }

    private long unpackEnd(long key) {
        return key >>> SHIFT;
    }

    private static final class IntMinHeap {
        private final int[] a;
        private int size = 0;

        IntMinHeap(int cap) {
            a = new int[cap];
        }

        boolean isEmpty() {
            return size == 0;
        }

        void push(int x) {
            int i = size++;
            a[i] = x;
            while (i > 0) {
                int p = (i - 1) >>> 1;
                if (a[p] <= a[i]) break;
                int tmp = a[p];
                a[p] = a[i];
                a[i] = tmp;
                i = p;
            }
        }

        int pop() {
            int res = a[0];
            int x = a[--size];
            if (size > 0) {
                a[0] = x;
                int i = 0;
                while (true) {
                    int l = (i << 1) + 1;
                    if (l >= size) break;
                    int r = l + 1;
                    int c = (r < size && a[r] < a[l]) ? r : l;
                    if (a[i] <= a[c]) break;
                    int tmp = a[i];
                    a[i] = a[c];
                    a[c] = tmp;
                    i = c;
                }
            }
            return res;
        }
    }

    private static final class LongMinHeap {
        private final long[] a;
        private int size = 0;

        LongMinHeap(int cap) {
            a = new long[cap];
        }

        boolean isEmpty() {
            return size == 0;
        }

        long peek() {
            return a[0];
        }

        void push(long x) {
            int i = size++;
            a[i] = x;
            while (i > 0) {
                int p = (i - 1) >>> 1;
                if (a[p] <= a[i]) break;
                long tmp = a[p];
                a[p] = a[i];
                a[i] = tmp;
                i = p;
            }
        }

        long pop() {
            long res = a[0];
            long x = a[--size];
            if (size > 0) {
                a[0] = x;
                int i = 0;
                while (true) {
                    int l = (i << 1) + 1;
                    if (l >= size) break;
                    int r = l + 1;
                    int c = (r < size && a[r] < a[l]) ? r : l;
                    if (a[i] <= a[c]) break;
                    long tmp = a[i];
                    a[i] = a[c];
                    a[c] = tmp;
                    i = c;
                }
            }
            return res;
        }
    }
}

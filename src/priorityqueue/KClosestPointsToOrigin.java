package priorityqueue;

import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
 *
 * @author AhogeK
 * @since 2025-06-25 21:30:13
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])
        );
        for (int[] p : points) pq.offer(p);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();
        return res;
    }
}

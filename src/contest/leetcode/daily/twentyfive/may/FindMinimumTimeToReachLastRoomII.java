package contest.leetcode.daily.twentyfive.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 3342. 到达最后一个房间的最少时间 II
 *
 * @author AhogeK
 * @since 2025-05-08 16:45:50
 */
public class FindMinimumTimeToReachLastRoomII {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(item -> item[2]));
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;
        // 上 右 下 左
        int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // [x, y, t]
        q.offer(new int[]{0, 0, 0});

        // Dijkstra
        while (dist[n - 1][m - 1] == Integer.MAX_VALUE) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            // 奇偶交替
            int edgeCost = (x + y) % 2 + 1;
            if (t > dist[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nextT = Math.max(t, moveTime[nx][ny]) + edgeCost;

                if (nextT < dist[nx][ny]) {
                    dist[nx][ny] = nextT;
                    q.offer(new int[]{nx, ny, nextT});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}

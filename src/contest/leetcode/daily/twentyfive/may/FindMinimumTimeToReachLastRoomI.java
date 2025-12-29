package contest.leetcode.daily.twentyfive.may;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3341. 到达最后一个房间的最少时间 I
 *
 * @author AhogeK
 * @since 2025-05-08 16:10:10
 */
public class FindMinimumTimeToReachLastRoomI {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        // 上 右 下 左
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        // [x, y, time]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];

            if (t > dist[x][y])
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                int canMove = Math.max(t, moveTime[nx][ny]);
                int nextT = canMove + 1;

                if (nextT < dist[nx][ny]) {
                    dist[nx][ny] = nextT;
                    q.offer(new int[]{nx, ny, nextT});
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}

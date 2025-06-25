package priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. 天际线问题
 *
 * @author AhogeK
 * @since 2025-06-25 21:47:57
 */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[] boundaries = new int[n * 2];
        for (int i = 0; i < n; i++) {
            boundaries[i * 2] = buildings[i][0];
            boundaries[i * 2 + 1] = buildings[i][1];
        }
        Arrays.sort(boundaries);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;
        for (int b : boundaries) {
           while (index < n && buildings[index][0] <= b) {
               pq.offer(new int[]{buildings[index][1], buildings[index][2]});
               index++;
           }
           while (!pq.isEmpty() && pq.peek()[0] <= b) pq.poll();
           int maxHeight = pq.isEmpty() ? 0 : pq.peek()[1];
           if (ans.isEmpty() || ans.getLast().get(1) != maxHeight) {
               ans.add(Arrays.asList(b, maxHeight));
           }
        }
        return ans;
    }
}

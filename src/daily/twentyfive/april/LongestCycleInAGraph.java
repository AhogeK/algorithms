package daily.twentyfive.april;

/**
 * <a href="https://leetcode.cn/problems/longest-cycle-in-a-graph">2360. 图中的最长环</a>
 *
 * @author AhogeK
 * @since 2025-03-29 11:25:52
 */
public class LongestCycleInAGraph {

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n]; // 全局访问标记
        int[] timeVisited = new int[n]; // 记录节点在当前遍历中的访问时间
        int maxCycle = -1;

        for (int i = 0, time = 1; i < n; i++) {
            if (visited[i]) continue; // 跳过已访问的节点

            int startTime = time; // 记录当前遍历的起始时间
            int current = i;

            // 沿着出边进行遍历
            while (current != -1 && !visited[current]) {
                visited[current] = true;
                timeVisited[current] = time++;
                current = edges[current];
            }

            // 如果遇到环，计算环的长度
            if (current != -1 && timeVisited[current] >= startTime) {
                // 环的长度为当前时间减去节点的访问时间
                maxCycle = Math.max(maxCycle, time - timeVisited[current]);
            }
        }
        return maxCycle;
    }

    public static void main(String[] args) {
        LongestCycleInAGraph solution = new LongestCycleInAGraph();
        System.out.println(solution.longestCycle(new int[]{3, 3, 4, 2, 3}));
    }
}

package graph.leetcode;

import java.util.Arrays;

/**
 * @author AhogeK
 * @since 2025-03-20 19:29:47
 */
public class MinimumReverseOperations {

    static int inf = Integer.MAX_VALUE / 2; // 使用一半的最大值避免溢出
    static int[] parent = new int[100000];  // 跳表数组
    static int[] que = new int[100000];     // BFS队列数组

    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        // 初始化距离数组
        int[] distances = new int[n];
        Arrays.fill(distances, inf);
        distances[p] = 0;                   // 起点距离为0
        for (int x : banned) distances[x] = -1; // 标记禁止访问的位置

        // 初始化parent数组 - 关键优化点
        // 每个位置初始指向i+2，形成一个"隔一个"的链表
        for (int i = 0; i < n; i++) parent[i] = i + 2;

        // BFS初始化
        int write = 0, read = 0;
        que[write++] = p;

        // BFS主循环
        while (read < write) {
            int u = que[read++], distance = distances[u] + 1;

            // 计算可达位置范围
            int min = Math.max(u - (k - 1), k - 1 - u);
            int max = Math.min(u + k - 1, n - k + n - 1 - u);

            // 获取max之后的下一个节点作为根节点
            int root = parent[max];

            // 高效遍历区间内所有符合条件的位置
            for (int v = min; v <= max; ) {
                if (distance < distances[v]) {
                    distances[v] = distance;
                    que[write++] = v;
                }

                // 链式跳表的更新操作 - 核心优化
                int next = parent[v];
                parent[v] = root;  // 将当前节点指向根节点
                v = next;          // 跳到下一个未处理的位置
            }
        }

        // 转换结果格式
        for (int i = 0; i < n; i++) {
            if (distances[i] == inf) distances[i] = -1;
        }

        return distances;
    }
}

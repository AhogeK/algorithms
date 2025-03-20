package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author AhogeK
 * @since 2025-03-20 18:42:29
 */
public class SimpleBFS {
    // 图的邻接表表示
    private List<Integer>[] graph;
    // 访问标记数组
    private boolean[] visited;

    /**
     * 初始化图结构
     * @param n 节点数量
     */
    public SimpleBFS(int n) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n];
    }

    /**
     * 添加无向边
     * @param u 节点1
     * @param v 节点2
     */
    public void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u); // 有向图时删除此行
    }

    /**
     * BFS核心时间
     * @param start 起始节点
     */
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 初始化起点
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            // 遍历所有邻接节点
            for (int v : graph[u]) {
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建包含6个节点的图
        SimpleBFS bfs = new SimpleBFS(6);

        // 构建示例图
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 4);
        bfs.addEdge(4, 5);

        System.out.println("BFS遍历顺序：");
        bfs.bfs(0); // 从节点0开始遍历
    }
}

package contest.leetcode.daily.twentysix.jan.twentyseventh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3650.边反转的最小路径总成本
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2026-01-27 09:02:58
 */
public class Solution {
    private static class FastGraph {
        final int[] head, to, next, cost;
        int idx = 0;

        FastGraph(int n, int m2) {
            head = new int[n];
            Arrays.fill(head, -1);
            to = new int[m2];
            next = new int[m2];
            cost = new int[m2];
        }

        void addEdge(int u, int v, int w) {
            to[idx] = v;
            cost[idx] = w;
            next[idx] = head[u];
            head[u] = idx++;
        }
    }

    record State(long dist, int node) {
    }

    public int minCost(int n, int[][] edges) {
        int m = edges.length;
        FastGraph g = new FastGraph(n, m << 1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            g.addEdge(u, v, w);
            g.addEdge(v, u, w << 1);
        }
        long inf = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingLong(State::dist));
        pq.add(new State(0L, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            long d = cur.dist;
            int u = cur.node;
            if (d != dist[u]) continue;
            if (u == n - 1) return (int) d;
            for (int ei = g.head[u]; ei != -1; ei = g.next[ei]) {
                int v = g.to[ei];
                long nd = d + g.cost[ei];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new State(nd, v));
                }
            }
        }
        return -1;
    }
}

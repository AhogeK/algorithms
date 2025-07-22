package unionfind;

/**
 * 952. 按公因数计算最大组件大小
 *
 * @author AhogeK
 * @since 2025-07-22 09:46:22
 */
public class LargestComponentSizeByCommonFactor {
    private static final int N = 100001;
    private static final int[] SIEVE = new int[N];

    private static void linearSieve() {
        for (int i = 2; i * i < N; i++) {
            if (SIEVE[i] != 0)
                continue;
            SIEVE[i] = i;
            for (int j = i * i; j < N; j += i)
                if (SIEVE[j] == 0)
                    SIEVE[j] = i;
        }
    }

    public static int largestComponentSize(int[] nums) {
        linearSieve();
        for (int i = 2; i < N; i++)
            if (SIEVE[i] == 0)
                SIEVE[i] = i;
        int m = 0;
        for (int x : nums)
            m = Math.max(m, x);
        UnionFind uf = new UnionFind(m + 1);
        for (int x : nums) {
            int t = x;
            while (t > 1) {
                int p = SIEVE[t];
                uf.union(x, p);
                while (t % p == 0)
                    t /= p;
            }
        }
        int[] counts = new int[m + 1];
        int res = 0;
        for (int x : nums) {
            int root = uf.find(x);
            res = Math.max(res, ++counts[root]);
        }
        return res;
    }

    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) return;
            if (rank[fx] < rank[fy]) parent[fx] = fy;
            else if (rank[fx] > rank[fy]) parent[fy] = fx;
            else {
                parent[fy] = fx;
                rank[fx]++;
            }
        }
    }
}

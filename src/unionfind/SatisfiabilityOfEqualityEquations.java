package unionfind;

/**
 * 990. 等式方程的可满足性
 *
 * @author AhogeK
 * @since 2025-07-20 00:43:22
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                uf.union(x, y);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (uf.find(x) == uf.find(y)) return false;
            }
        }
        return true;
    }

    static class UnionFind {
        int[] parent = new int[26];
        int[] rank = new int[26];

        UnionFind() {
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
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

package unionfind;

/**
 * 765. 情侣牵手
 *
 * @author AhogeK
 * @since 2025-09-06 18:53:27
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < row.length; i += 2) {
            int personA = row[i];
            int personB = row[i + 1];
            int coupleAId = personA / 2;
            int coupleBId = personB / 2;
            if (coupleAId != coupleBId)
                uf.union(coupleAId, coupleBId);
        }
        return n - uf.getCount();
    }

    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return;
            if (rank[rootI] < rank[rootJ]) parent[rootI] = rootJ;
            else if (rank[rootI] > rank[rootJ]) parent[rootJ] = rootI;
            else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}

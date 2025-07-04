package unionfind;

/**
 * 547. 省份数量
 *
 * @author AhogeK
 * @since 2025-07-04 15:49:12
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && id[i] != id[j]) {
                    int from = id[i];
                    int to = id[j];
                    for (int k = 0; k < n; k++)
                        if (id[k] == from)
                            id[k] = to;
                }
            }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[id[i]]) {
                count++;
                vis[id[i]] = true;
            }
        }
        return count;
    }
}

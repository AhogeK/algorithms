package daily.twentyfive.nov;

/**
 * 3228. 将 1 移动到末尾的最大操作次数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-13 13:27:35
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public int maxOperations(String s) {
        int ans = 0;
        int cnt1 = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '1') {
                cnt1++;
                if (i + 1 < n && cs[i + 1] == '0') {
                    ans += cnt1;
                }
            }
        }
        return ans;
    }
}

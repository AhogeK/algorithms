package daily.twentyfive.dec;

/**
 * 944. 删列造序
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-20 02:06:05
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) return 0;
        int rows = strs.length;
        int cols = strs[0].length();
        int deleteCount = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
                    deleteCount++;
                    break;
                }
            }
        }
        return deleteCount;
    }
}

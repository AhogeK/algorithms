package daily.twentyfive.oct;

/**
 * 2011. 执行操作后的变量值
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-10-20 18:56:51
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            x += op.charAt(1) == '+' ? 1 : -1;
        }
        return x;
    }
}

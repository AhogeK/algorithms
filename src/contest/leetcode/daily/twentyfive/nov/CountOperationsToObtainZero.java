package contest.leetcode.daily.twentyfive.nov;

/**
 * 2169. 得到 0 的操作数
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-09 13:59:06
 */
public class CountOperationsToObtainZero {
    public int countOperations(int num1, int num2) {
        int cnt = 0;
        while (num2 > 0) {
            cnt += num1 / num2;
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return cnt;
    }
}

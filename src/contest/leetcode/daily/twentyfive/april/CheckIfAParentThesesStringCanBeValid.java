package contest.leetcode.daily.twentyfive.april;

/**
 * 2025-03-23 每日一题
 * <a href="https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid">2116. 判断一个括号字符串是否有效</a>
 *
 * @author AhogeK
 * @since 2025-03-23 21:52:06
 */
public class CheckIfAParentThesesStringCanBeValid {

    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        // 基本检查：长度必须是偶数
        if (n % 2 == 1) return false;

        // 边界检查：明显无效的情况
        if (n > 0 && s.charAt(0) == ')' && locked.charAt(0) == '1') return false;
        if (n > 0 && s.charAt(n - 1) == '(' && locked.charAt(n - 1) == '1') return false;

        int max = 0; // 最大可能的未匹配左括号数
        int min = 0; // 最小可能的未匹配左括号数

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') { // 字符被锁定
                int diff;
                if (s.charAt(i) == '(') diff = 1; // 左括号 +1
                else diff = -1; // 右括号 -1

                max += diff;
                min = Math.max(min + diff, (i + 1) % 2);
            } else { // 可替换
                max++; // 可以替换为左括号，增加上限
                min = Math.max(min - 1, (i + 1) % 2); // 可以替换为右括号，减少下限
            }

            if (max < min) return false; // 上限小于下限，无解
        }

        return min == 0; // 最终需要所有左括号都匹配
    }

    // 测试代码
    public static void main(String[] args) {
        CheckIfAParentThesesStringCanBeValid solution = new CheckIfAParentThesesStringCanBeValid();
        System.out.println(solution.canBeValid("))()))", "010100")); // 输出：true
        System.out.println(solution.canBeValid("()()", "0000"));     // 输出：true
        System.out.println(solution.canBeValid(")", "0"));           // 输出：false
    }
}

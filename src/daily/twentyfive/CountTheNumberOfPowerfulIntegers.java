package daily.twentyfive;

/**
 * @author AhogeK
 * @since 2025-04-10 08:04:16
 */
public class CountTheNumberOfPowerfulIntegers {
    private String s;
    private String t;
    private Long[] f;
    private int limit;

    public static void main(String[] args) {
        CountTheNumberOfPowerfulIntegers solution = new CountTheNumberOfPowerfulIntegers();
        System.out.println(solution.numberOfPowerfulInt(125, 6000, 4, "124"));
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s = s;
        this.limit = limit;

        // 计算 [1, start - 1]中的强大整数数量
        t = String.valueOf(start - 1);
        f = new Long[20];
        long a = dfs(0, true);

        // 计算 [1, finish]中的强大整数数量
        t = String.valueOf(finish);
        f = new Long[20];
        long b = dfs(0, true);

        // 区间 [start, finish] 中的强大整数数量 = b - a
        return b - a;
    }

    private long dfs(int pos, boolean lim) {
        // 如果 t 的长度小于 s 的长度，不可能形成以 s 为后缀的数字
        if (t.length() < s.length())
            return 0;

        // 使用记忆化搜索，仅当不受限制时有效
        if (!lim && f[pos] != null)
            return f[pos];

        // 当剩余位数等于 s 的长度时，判断是否可以形成合法后缀
        if (t.length() - pos == s.length()) {
            if (!lim) return 1;
            return s.compareTo(t.substring(pos)) <= 0 ? 1 : 0;
        }

        // 确定当前位可填入数字的上限
        int up = lim ? t.charAt(pos) - '0' : 9;
        up = Math.min(up, limit);

        long ans = 0;
        // 枚举当前位可以填入所有数字
        for (int i = 0; i <= up; i++)
            // 递归计算下一位并累加结果
            ans += dfs(pos + 1, lim && i == (t.charAt(pos) - '0'));


        // 记忆化存储，仅当不受限制时有效
        if (!lim)
            f[pos] = ans;

        return ans;
    }
}

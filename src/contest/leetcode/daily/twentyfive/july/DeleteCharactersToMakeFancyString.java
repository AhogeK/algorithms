package contest.leetcode.daily.twentyfive.july;

/**
 * 1957. 删除字符使字符串变好
 *
 * @author AhogeK
 * @since 2025-07-21 20:40:44
 */
public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        int n = s.length();
        int j = 0;
        char[] cs = s.toCharArray();
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == cs[j] && cs[i] == cs[i + 1]) continue;
            cs[++j] = cs[i];
        }
        if (j < n - 1)
            cs[++j] = cs[n - 1];
        return new String(cs, 0, j + 1);
    }
}

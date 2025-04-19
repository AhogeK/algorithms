package daily.twentyfive;

/**
 * 2025-3-28
 * <a href="https://leetcode.cn/problems/minimize-string-length">2716. 最小化字符串长度</a>
 *
 * @author AhogeK
 * @since 2025-03-28 20:05:18
 */
public class MinimizeStringLength {

    public int minimizedStringLength(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return Integer.bitCount(mask);
    }

    public static void main(String[] args) {
        MinimizeStringLength solution = new MinimizeStringLength();
        System.out.println(solution.minimizedStringLength("aaabbb"));
    }
}

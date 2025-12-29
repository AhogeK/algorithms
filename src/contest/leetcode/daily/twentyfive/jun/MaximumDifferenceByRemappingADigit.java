package contest.leetcode.daily.twentyfive.jun;

/**
 * 2566. 替换一个数字后的最大差值
 *
 * @author AhogeK
 * @since 2025-06-14 23:14:47
 */
public class MaximumDifferenceByRemappingADigit {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }
}

package contest.leetcode.daily.twentyfive.jun;

/**
 * 1432. 改变一个整数能得到的最大差值
 *
 * @author AhogeK ahogek@gmail.com
 * @since 2025-06-15 15:58:57
 */
public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public int maxDiff(int num) {
        int maxNum = num;
        int minNum = num;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                maxNum = Integer.parseInt(s.replace(s.charAt(i), '9'));
                break;
            }
        }
        if (s.charAt(0) != '1') {
            minNum = Integer.parseInt(s.replace(s.charAt(0), '1'));
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) > '1') {
                    minNum = Integer.parseInt(s.replace(s.charAt(i), '0'));
                    break;
                }
            }
        }
        return maxNum - minNum;
    }
}

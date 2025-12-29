package contest.leetcode.daily.twentyfive.jun;

/**
 * 2138. 将字符串拆分为若干长度为 k 的组
 *
 * @author AhogeK
 * @since 2025-06-22 18:16:49
 */
public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] ans = new String[(n + k - 1) / k];
        int curr = 0;
        while (curr < n) {
            int end = Math.min(curr + k, n);
            ans[curr / k] = s.substring(curr, end);
            curr += k;
        }
        String last = ans[ans.length - 1];
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            ans[ans.length - 1] = last;
        }
        return ans;
    }
}

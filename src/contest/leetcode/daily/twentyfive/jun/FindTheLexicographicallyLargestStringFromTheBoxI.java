package contest.leetcode.daily.twentyfive.jun;

/**
 * 3403. 从盒子中找出字典序最大的字符串 I
 *
 * @author AhogeK
 * @since 2025-06-04 10:22:54
 */
public class FindTheLexicographicallyLargestStringFromTheBoxI {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) return word;
        int i = 0, j = 1;
        while (j < n) {
            int k = 0;
            while (j + k < n && word.charAt(i + k) == word.charAt(j + k)) k++;
            if (j + k < n && word.charAt(i + k) < word.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j += k + 1;
            }
        }
        return word.substring(i, Math.min(i + n - numFriends + 1, n));
    }
}

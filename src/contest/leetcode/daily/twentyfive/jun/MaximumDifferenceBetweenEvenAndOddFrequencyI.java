package contest.leetcode.daily.twentyfive.jun;

import java.util.Arrays;

/**
 * 3442. 奇偶频次间的最大差值 I
 *
 * @author AhogeK
 * @since 2025-06-10 19:18:57
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public int maxDifference(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        int doubles = 1000;
        int single = -1000;
        Arrays.sort(chars);
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                if (chars[i] % 2 == 1)
                    single = Math.max(chars[i], single);
                else
                    doubles = Math.min(chars[i], doubles);
            }
        }
        return single - doubles;
    }
}

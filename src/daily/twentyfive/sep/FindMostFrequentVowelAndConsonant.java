package daily.twentyfive.sep;

/**
 * 3541. 找到频率最高的元音和辅音
 *
 * @author AhogeK
 * @since 2025-09-13 07:31:19
 */
public class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;
        int maxVowel = 0;
        int maxConsonant = 0;
        for (int i = 0; i < 26; i++)
            if (isVowel[i])
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConsonant = Math.max(maxConsonant, freq[i]);
        return maxVowel + maxConsonant;
    }
}

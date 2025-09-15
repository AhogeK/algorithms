package daily.twentyfive.sep;

/**
 * 1935. 可以输入的最大单词数
 *
 * @author AhogeK
 * @since 2025-09-15 11:31:19
 */
public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int mask = 0;
        for (char c : brokenLetters.toCharArray()) mask |= 1 << (c - 'a');
        char[] s = text.toCharArray();
        int count = 0;
        int ok = 1;
        for (char c : s) {
            if (c == ' ') {
                count += ok;
                ok = 1;
            } else {
                ok &= ((mask >> (c - 'a')) & 1) ^ 1;
            }
        }
        count += ok;
        return count;
    }
}

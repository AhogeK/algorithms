package daily.twentyfive.april;

/**
 * <a href="https://leetcode.cn/problems/percentage-of-letter-in-string">2278. 字母在字符串中的百分比</a>
 *
 * @author AhogeK
 * @since 2025-03-31 07:50:38
 */
public class PercentageOfLetterInString {

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                count++;
            }
        }
        return count * 100 / s.length();
    }

    public static void main(String[] args) {
        PercentageOfLetterInString percentageOfLetterInString = new PercentageOfLetterInString();
        System.out.println(percentageOfLetterInString.percentageLetter("foobar", 'o'));
    }
}

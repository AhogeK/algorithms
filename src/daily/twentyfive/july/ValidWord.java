package daily.twentyfive.july;

/**
 * 3136. 有效单词
 *
 * @author AhogeK
 * @since 2025-07-15 23:00:56
 */
public class ValidWord {
    public boolean isValid(String word) {
        if (word.length() <= 2) return false;
        boolean isVowel = false;
        boolean isConstant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') continue;
            else if (c >= 'A' && c <= 'Z')
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    isVowel = true;
                else
                    isConstant = true;
            else if (c >= 'a' && c <= 'z')
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    isVowel = true;
                else
                    isConstant = true;
            else
                return false;
        }
        return isConstant && isVowel;
    }
}

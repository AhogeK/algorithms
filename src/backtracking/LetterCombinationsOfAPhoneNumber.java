package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-01 13:15:14
 */
public class LetterCombinationsOfAPhoneNumber {
    private static final String[] KEYS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack(digits, result, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(String digits, List<String> result, StringBuilder currentPath, int index) {
        if (index == digits.length()) {
            result.add(currentPath.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = KEYS[digit];
        for (int i = 0; i < letters.length(); i++) {
            currentPath.append(letters.charAt(i));
            backtrack(digits, result, currentPath, index + 1);
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
}

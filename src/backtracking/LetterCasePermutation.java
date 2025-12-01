package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-01 15:30:55
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, res);
        return res;
    }

    private void dfs(char[] chars, int index, List<String> res) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (Character.isDigit(chars[index])) {
            dfs(chars, index + 1, res);
            return;
        }
        dfs(chars, index + 1, res);
        chars[index] ^= 32;
        dfs(chars, index + 1, res);
        chars[index] ^= 32;
    }
}

package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 1593. 拆分字符串使唯一子字符串的数目最大
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-11-30 04:31:27
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    private int maxCount = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>());
        return maxCount;
    }

    private void backtrack(String s, int start, Set<String> seen) {
        int length = s.length();
        if (start == length) {
            maxCount = Math.max(maxCount, seen.size());
            return;
        }
        if (seen.size() + (length - start) <= maxCount) return;
        for (int i = start + 1; i <= length; i++) {
            String sub = s.substring(start, i);
            if (!seen.contains(sub)) {
                seen.add(sub);
                backtrack(s, i, seen);
                seen.remove(sub);
            }
        }
    }
}

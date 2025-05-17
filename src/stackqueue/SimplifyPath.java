package stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. 简化路径
 *
 * @author AhogeK
 * @since 2025-05-17 17:57:44
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        int len = path.length();
        Deque<String> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < len) {
            while (idx < len && path.charAt(idx) == '/')
                idx++;
            if (idx == len) break;
            int end = idx;
            while (end < len && path.charAt(end) != '/')
                end++;
            String segment = path.substring(idx, end);
            if (segment.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!segment.equals(".")) {
                stack.offerLast(segment);
            }
            idx = end;
        }
        if (stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        return res.toString();
    }
}

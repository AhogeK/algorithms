package backtracking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 752. 打开转盘锁
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-05 15:29:31
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);
        String start = "0000";
        if (dead.contains(start)) return -1;
        if (start.equals(target)) return 0;
        Set<String> front = new HashSet<>();
        Set<String> back = new HashSet<>();
        front.add(start);
        back.add(target);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(target);
        int step = 0;
        while (!front.isEmpty() && !back.isEmpty()) {
            if (front.size() > back.size()) {
                Set<String> tmp = front;
                front = back;
                back = tmp;
            }
            Set<String> next = new HashSet<>();
            for (String cur : front) {
                if (dead.contains(cur)) continue;
                for (int i = 0; i < 4; i++) {
                    char[] chars = cur.toCharArray();
                    chars[i] = up(chars[i]);
                    String upState = new String(chars);
                    if (back.contains(upState)) return step + 1;
                    if (!visited.contains(upState) && !dead.contains(upState)) {
                        visited.add(upState);
                        next.add(upState);
                    }
                    chars = cur.toCharArray();
                    chars[i] = down(chars[i]);
                    String downState = new String(chars);
                    if (back.contains(new String(chars))) return step + 1;
                    if (!visited.contains(downState) && !dead.contains(downState)) {
                        visited.add(downState);
                        next.add(downState);
                    }
                }
            }
            front = next;
            step++;
        }
        return -1;
    }

    private char up(char c) {
        return c == '9' ? '0' : (char)(c + 1);
    }

    private char down(char c) {
        return c == '0' ? '9' : (char)(c - 1);
    }
}

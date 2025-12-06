package backtracking;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 773. 滑动谜题
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-06 19:34:05
 */
public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board)
            for (int num : row)
                sb.append(num);
        String start = sb.toString();
        String target = "123450";
        if (start.equals(target)) return 0;
        int[][] neighbors = {
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int zeroIdx = curr.indexOf('0');
                for (int neighborIdx : neighbors[zeroIdx]) {
                    String next = swap(curr, zeroIdx, neighborIdx);
                    if (next.equals(target)) return step + 1;
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}

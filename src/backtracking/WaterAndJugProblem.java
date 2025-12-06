package backtracking;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 365. 水壶问题
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-06 16:51:38
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;
        Deque<Long> stack = new ArrayDeque<>();
        Set<Long> visited = new HashSet<>();
        stack.push(0L);
        visited.add(0L);
        while (!stack.isEmpty()) {
            long state = stack.pop();
            int curX = (int) (state / 100_000);
            int curY = (int) (state % 100_000);
            if (curX + curY == target || curX == target || curY == target) return true;
            addState(x, curY, stack, visited);
            addState(curX, y, stack, visited);
            addState(0, curY, stack, visited);
            addState(curX, 0, stack, visited);
            int moveXtoY = Math.min(curX, y - curY);
            addState(curX - moveXtoY, curY + moveXtoY, stack, visited);
            int moveYtoX = Math.min(curY, x - curX);
            addState(curX + moveYtoX, curY - moveYtoX, stack, visited);
        }
        return false;
    }

    private void addState(int newX, int newY, Deque<Long> stack, Set<Long> visited) {
        long hash = (long) newX * 100_000 + newY;
        if (visited.contains(hash)) return;
        visited.add(hash);
        stack.push(hash);
    }
}

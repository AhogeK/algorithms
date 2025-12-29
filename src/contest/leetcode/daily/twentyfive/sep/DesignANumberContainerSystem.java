package contest.leetcode.daily.twentyfive.sep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2349. 设计数字容器系统
 *
 * @author AhogeK
 * @since 2025-09-17 13:08:30
 */
public class DesignANumberContainerSystem {
    class NumberContainers {
        private Map<Integer, Integer> nums = new HashMap<>();
        private Map<Integer, PriorityQueue<Integer>> heaps = new HashMap<>();

        public NumberContainers() {
        }

        public void change(int index, int number) {
            nums.put(index, number);
            heaps.computeIfAbsent(number, _ -> new PriorityQueue<>()).add(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> heap = heaps.get(number);
            if (heap == null) return -1;
            while (!heap.isEmpty() && !nums.get(heap.peek()).equals(number)) heap.poll();
            return heap.isEmpty() ? -1 : heap.peek();
        }
    }
}

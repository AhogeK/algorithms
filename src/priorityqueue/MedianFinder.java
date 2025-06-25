package priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. 数据流的中位数
 *
 * @author AhogeK
 * @since 2025-06-25 19:42:34
 */
public class MedianFinder {
    private final PriorityQueue<Integer> smaller;
    private final PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>((a, b) -> b - a);
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.isEmpty() || smaller.peek() >= num) smaller.offer(num);
        else larger.offer(num);
        if (smaller.size() > larger.size() + 1) larger.offer(smaller.poll());
        else if (larger.size() > smaller.size()) smaller.offer(larger.poll());
    }

    public double findMedian() {
        int size = smaller.size() + larger.size();
        if (size == 0) return 0.0;
        if (size % 2 == 0) return (smaller.peek() + larger.peek()) / 2.0;
        else return smaller.peek();
    }
}

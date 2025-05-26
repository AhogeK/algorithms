package stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 *
 * @author AhogeK
 * @since 2025-05-26 23:08:20
 */
public class MyQueue {

    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        move();
        return outStack.pop();
    }

    public int peek() {
        move();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void move() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}

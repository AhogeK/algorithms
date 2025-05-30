package stackqueue;

/**
 * 622. 设计循环队列
 *
 * @author AhogeK
 * @since 2025-05-28 06:37:54
 */
public class MyCircularQueue {
    private final int[] q;
    private final int cap;
    private int front;
    private int rear;

    public MyCircularQueue(int k) {
        this.cap = k + 1;
        this.q = new int[this.cap];
        this.front = 0;
        this.rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % cap;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % cap;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[(rear - 1 + cap) % cap];
    }

    private boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return (rear + 1) % cap == front;
    }
}

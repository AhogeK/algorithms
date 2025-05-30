package stackqueue;

/**
 * 641. 设计循环双端队列
 *
 * @author AhogeK
 * @since 2025-05-30 14:35:18
 */
public class MyCircularDeque {
    private int[] data;
    private int front, rear;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return data[(rear - 1 + capacity) % capacity];
    }

    private boolean isEmpty() {
        return front == rear;
    }

    private boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

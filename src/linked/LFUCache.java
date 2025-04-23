package linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 *
 * @author AhogeK
 * @since 2025-04-23 11:06:31
 */
public class LFUCache {
    int minFreq, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, DoublyLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0 || !keyTable.containsKey(key)) return -1;

        Node node = keyTable.get(key);
        int val = node.val;
        int freq = node.freq;
        freqTable.get(freq).remove(node);
        // 如果当前频率的链表为空，则需要删除该频率的链表
        if (freqTable.get(freq).size == 0) {
            freqTable.remove(freq);
            // 如果当前频率是最小频率，则需要更新最小频率
            if (minFreq == freq) minFreq++;
        }
        node.freq++;
        freqTable.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyTable.containsKey(key)) {
            Node node = keyTable.get(key);
            node.val = value;
            // 直接利用 get 方法，更新频率，并更新节点的值
            get(key);
        } else {
            if (keyTable.size() == capacity) {
                Node node = freqTable.get(minFreq).getTail();
                keyTable.remove(node.key);
                freqTable.get(minFreq).remove(node);
                if (freqTable.get(minFreq).size == 0)
                    freqTable.remove(minFreq);
            }
            Node node = new Node(key, value, 1);
            freqTable.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(node);
            keyTable.put(key, node);
            minFreq = 1;
        }
    }
}

class Node {
    int key, val, freq;
    Node prev, next;

    Node() {
        this(-1, -1, 0);
    }

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList {
    Node dummyHead, dummyTail;
    int size;

    DoublyLinkedList() {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    public void addFirst(Node node) {
        Node next = dummyHead.next;
        node.prev = dummyHead;
        node.next = next;
        next.prev = node;
        dummyHead.next = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node getTail() {
        return dummyTail.prev;
    }
}
package linked;

import java.util.HashMap;

/**
 * 146. LRU 缓存
 *
 * @author AhogeK
 * @since 2025-04-23 10:15:21
 */
public class LRUCache {

    private final int capacity;
    private final HashMap<Integer, Node> map;
    // 虚拟头尾节点
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 删除节点
     *
     * @param node 待删除的节点
     */
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 插入节点到头部
     *
     * @param node 待插入的节点
     */
    private void insertToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        // 只有不在头部才做操作
        if (head.next != node) {
            // 先移除旧位置
            remove(node);
            // 再插到头部
            insertToHead(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 更新值
            node.value = value;
            if (head.next != node) {
                remove(node);
                insertToHead(node);
            }
        } else {
            if (map.size() == capacity) {
                // 淘汰尾部节点
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertToHead(node);
        }
    }

    /**
     * 双向链表节点
     */
    static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }
}

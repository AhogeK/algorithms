package linked;

import java.util.Random;

/**
 * 1206. 设计跳表
 *
 * @author AhogeK
 * @since 2025-04-24 13:15:57
 */
public class Skiplist {
    // 全局复用避免重复实例
    private static final Random rand = new Random();
    private static final int S = 0xFFFF;
    // 层提升概率
    private static final double P = 0.5;
    private static final int PS = (int) (S * P);
    private static final int MAX_LEVEL = 16;
    // 哨兵头节点
    private Node head = new Node(-1, MAX_LEVEL);
    // 当前跳表最大使用层数
    private int level = 1;

    /**
     * 随机生成层数
     *
     * @return 层数
     */
    private int randomLevel() {
        // 初始层
        int lv = 1;
        while ((rand.nextInt() & S) < PS) {
            lv++;
            if (lv >= MAX_LEVEL) break;
        }
        return lv;
    }

    /**
     * 查找元素
     *
     * @param target 目标元素
     * @return 是否存在
     */
    public boolean search(int target) {
        Node curr = head;
        // 从高层到低层查找
        for (int i = level - 1; i >= 0; i--) {
            while (curr.next[i] != null && curr.next[i].val < target)
                curr = curr.next[i];
        }
        curr = curr.next[0];
        return curr != null && curr.val == target;
    }

    /**
     * 添加元素
     *
     * @param num 待添加的元素
     */
    public void add(int num) {
        // 路径存储
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;
        // 路径查找，每一层找到最后小于 num 的节点
        for (int i = level - 1; i >= 0; i--) {
            // 找前驱节点
            while (curr.next[i] != null && curr.next[i].val < num)
                curr = curr.next[i];
            // 记录需要变更指针的节点
            update[i] = curr;
        }
        int lv = randomLevel();
        if (lv > level) {
            for (int i = level; i < lv; i++)
                update[i] = head;
            level = lv;
        }
        Node node = new Node(num, lv);
        for (int i = 0; i < lv; i++) {
            // 节点的下一个节点就是前驱节点的下一个节点
            node.next[i] = update[i].next[i];
            // 前驱节点的下一个节点就是当前节点
            update[i].next[i] = node;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            // 找待断连的节点的前驱节点
            while (curr.next[i] != null && curr.next[i].val < num)
                curr = curr.next[i];
            update[i] = curr;
        }
        // 此时在第一层，第一层包含所有数字，所以可以先判断要删除的数字是否存在
        curr = curr.next[0];
        if (curr == null || curr.val != num) return false;
        // 多层断链
        for (int i = 0; i < level; i++) {
            // 边界，跳表可能不存在该节点
            if (update[i].next[i] != curr) break;
            // 断链，将前驱节点的下一个节点指向断链节点的下一个节点
            update[i].next[i] = curr.next[i];
        }
        // 动态降低跳表的高度（因为可能会存在最高层且只有一个要删的元素）
        while (level > 1 && head.next[level - 1] == null)
            level--;
        return true;
    }

    static class Node {
        int val;
        Node[] next;

        Node(int val, int level) {
            this.val = val;
            next = new Node[level];
        }
    }
}

package common;

import java.util.List;

/**
 * Definition for a Node.
 *
 * @author AhogeK
 * @since 2025-09-19 17:06:55
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

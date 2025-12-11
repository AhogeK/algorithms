package common;

import java.util.ArrayList;
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
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val, List<Node> _children, List<Node> _neighbors) {
        val = _val;
        children = _children;
        neighbors = _neighbors;
    }
}

package backtracking;

import common.Node;

/**
 * 133. 克隆图
 *
 * @author AhogeK [ahogek@gmail.com]
 * @since 2025-12-11 17:26:29
 */
public class CloneGraph {
    private final Node[] visited = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited[node.val] != null) return visited[node.val];
        Node cloneNode = new Node(node.val);
        visited[node.val] = cloneNode;
        for (Node neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneGraph(neighbor));
        return cloneNode;
    }
}

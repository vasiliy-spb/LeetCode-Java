package matrix.workingPeoplesImitation.task_559_Maximum_Depth_of_Nary_Tree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Solution {

    // my solution
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int level = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.children != null && !current.children.isEmpty()) {
                    for (Node child : current.children)
                        queue.offer(child);
                }
            }
        }
        return level;
    }

    // from walkccc.me
    public int maxDepth2(Node root) {
        if (root == null)
            return 0;

        int ans = 0;

        for (Node child : root.children)
            ans = Math.max(ans, maxDepth(child));

        return 1 + ans;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
package matrix.workingPeoplesImitation.task_988_Smallest_String_Starting_From_Leaf;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.TreeSet;

class Solution {
    public String smallestFromLeaf(TreeNode root) {
        TreeSet<String> result = new TreeSet<>();
        Queue<TreeNode> nodeDeque = new ArrayDeque<>();
        Queue<StringBuilder> pathDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        char ch = (char) ('a' + root.val);
        pathDeque.offer(new StringBuilder("" + ch));
        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = nodeDeque.poll();
                StringBuilder path = pathDeque.poll();
                if (current.left == null && current.right == null) result.add(path.toString());
                if (current.left != null) {
                    char nextCh = (char) ('a' + current.left.val);
                    nodeDeque.offer(current.left);
                    pathDeque.offer(new StringBuilder(nextCh + path.toString()));
                }
                if (current.right != null) {
                    char nextCh = (char) ('a' + current.right.val);
                    nodeDeque.offer(current.right);
                    pathDeque.offer(new StringBuilder(nextCh + path.toString()));
                }
            }
        }
        return result.first();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package matrix.workingPeoplesImitation.task_111_Minimum_Depth_of_Binary_Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minLevel = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            minLevel++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) return minLevel;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return 0;
    }

    // from walkccc.me (Approach 1: Top-down DFS)
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // from walkccc.me (Approach 2: Bottom-up BFS)
    public int minDepth3(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return ans;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        throw new IllegalArgumentException();
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
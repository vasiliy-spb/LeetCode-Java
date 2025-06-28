package matrix.workingPeoplesImitation.task_1609_Even_Odd_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode prev = queue.poll();
            int prevVal = prev.val;
            if (level % 2 == 0 && prevVal % 2 == 0) return false;
            if (level % 2 != 0 && prevVal % 2 != 0) return false;
            if (prev.left != null) queue.offer(prev.left);
            if (prev.right != null) queue.offer(prev.right);
            for (int i = 1; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (level % 2 == 0) {
                    if (prevVal % 2 == 0) return false;
                    if (current.val % 2 == 0 || current.val <= prevVal) return false;
                } else {
                    if (prevVal % 2 != 0) return false;
                    if (current.val % 2 != 0 || current.val >= prevVal) return false;
                }
                prevVal = current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            level++;
        }
        return true;
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
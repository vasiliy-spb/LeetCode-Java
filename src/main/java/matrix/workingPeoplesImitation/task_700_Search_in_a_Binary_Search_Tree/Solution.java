package matrix.workingPeoplesImitation.task_700_Search_in_a_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution (recursive approach)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    // my solution (iterative approach)
    public TreeNode searchBST1(TreeNode root, int val) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == val) return current;
            if (current.val > val && current.left != null) queue.offer(current.left);
            if (current.val < val && current.right != null) queue.offer(current.right);
        }
        return null;
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
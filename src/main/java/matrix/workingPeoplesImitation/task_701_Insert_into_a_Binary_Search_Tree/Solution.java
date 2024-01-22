package matrix.workingPeoplesImitation.task_701_Insert_into_a_Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (val < current.val) {
                if (current.left != null) queue.offer(current.left);
                else {
                    current.left = new TreeNode(val);
                    return root;
                }
            } else {
                if (current.right != null) queue.offer(current.right);
                else {
                    current.right = new TreeNode(val);
                    return root;
                }
            }
        }
        return root;
    }

    // from walkccc.me
    public TreeNode insertIntoBST3(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val)
            root.left = insertIntoBST3(root.left, val);
        else
            root.right = insertIntoBST3(root.right, val);
        return root;
    }

    // my solution (don't work correctly)
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) {
            if (root.left != null) return insertIntoBST2(root.left, val);
            else root.left = new TreeNode(val);
        } else {
            if (root.right != null) return insertIntoBST2(root.right, val);
            else root.right = new TreeNode(val);
        }
        return root;
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
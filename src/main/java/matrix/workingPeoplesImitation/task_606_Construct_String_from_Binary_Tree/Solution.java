package matrix.workingPeoplesImitation.task_606_Construct_String_from_Binary_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    public String tree2str(TreeNode root) {
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        } else if (root.right == null) {
            return String.format("%d(%s)", root.val, tree2str(root.left));
        } else if (root.left == null) {
            return String.format("%d()(%s)", root.val, tree2str(root.right));
        } else {
            return String.format("%d(%s)(%s)", root.val, tree2str(root.left), tree2str(root.right));
        }
    }
}

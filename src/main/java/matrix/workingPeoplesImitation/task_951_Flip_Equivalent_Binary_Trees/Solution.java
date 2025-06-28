package matrix.workingPeoplesImitation.task_951_Flip_Equivalent_Binary_Trees;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// my solution
public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.left == null && root1.right == null && root2.left == null && root2.right == null) {
            return root1.val == root2.val;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean ans = true;
        if (root1.left != null && root2.left != null && root1.left.val == root2.left.val) {
            ans &= flipEquiv(root1.left, root2.left);
            ans &= flipEquiv(root1.right, root2.right);
        } else if (root1.right != null && root2.right != null && root1.right.val == root2.right.val) {
            ans &= flipEquiv(root1.right, root2.right);
            ans &= flipEquiv(root1.left, root2.left);
        } else {
            ans &= flipEquiv(root1.left, root2.right);
            ans &= flipEquiv(root1.right, root2.left);
        }
        return ans;
    }
}

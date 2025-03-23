package matrix.workingPeoplesImitation.task_606_Construct_String_from_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// my solution
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

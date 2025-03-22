package matrix.workingPeoplesImitation.task_114_Flatten_Binary_Tree_to_Linked_List;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me (Approach 1: Recursive)
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;   // flattened left
        TreeNode right = root.right; // flattened right

        root.left = null;
        root.right = left;

        // Connect the original right subtree to the end of the new right subtree.
        TreeNode rightmost = root;
        while (rightmost.right != null)
            rightmost = rightmost.right;
        rightmost.right = right;
    }
}

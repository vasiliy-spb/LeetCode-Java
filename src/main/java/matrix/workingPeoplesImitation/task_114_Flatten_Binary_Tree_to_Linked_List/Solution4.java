package matrix.workingPeoplesImitation.task_114_Flatten_Binary_Tree_to_Linked_List;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me (Approach 3: Morris-like)
public class Solution4 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        while (root != null) {
            if (root.left != null) {
                // Find the rightmost root.
                TreeNode rightmost = root.left;
                while (rightmost.right != null)
                    rightmost = rightmost.right;
                // Rewire the connections.
                rightmost.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            // Move on to the right side of the tree.
            root = root.right;
        }
    }
}

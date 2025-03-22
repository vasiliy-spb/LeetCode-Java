package matrix.workingPeoplesImitation.task_114_Flatten_Binary_Tree_to_Linked_List;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (1)
public class Solution5 {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}

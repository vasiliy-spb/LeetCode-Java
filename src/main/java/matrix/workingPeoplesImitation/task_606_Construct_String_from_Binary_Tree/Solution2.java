package matrix.workingPeoplesImitation.task_606_Construct_String_from_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me
public class Solution2 {
    public String tree2str(TreeNode t) {
        return dfs(t);
    }

    private String dfs(TreeNode root) {
        if (root == null)
            return "";
        if (root.right != null)
            return root.val + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
        if (root.left != null)
            return root.val + "(" + dfs(root.left) + ")";
        return root.val + "";
    }
}

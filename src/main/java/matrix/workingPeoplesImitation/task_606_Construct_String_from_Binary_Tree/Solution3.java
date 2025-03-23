package matrix.workingPeoplesImitation.task_606_Construct_String_from_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (1)
public class Solution3 {
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString();
    }

    public static void dfs(TreeNode root, StringBuilder res) {
        if (root == null)
            return;

        res.append(String.valueOf(root.val));
        if (root.left == null && root.right == null)
            return;

        res.append('(');
        dfs(root.left, res);
        res.append(')');
        if (root.right != null) {
            res.append('(');
            dfs(root.right, res);
            res.append(')');
        }
    }
}

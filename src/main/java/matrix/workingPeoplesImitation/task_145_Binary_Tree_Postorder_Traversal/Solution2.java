package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me (Approach 1: Recursive)
public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}

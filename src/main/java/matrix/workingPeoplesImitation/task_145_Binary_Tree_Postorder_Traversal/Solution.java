package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;


// my solution
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            dfs(root, ans);
        }
        return ans;
    }
    private void dfs(TreeNode root, List<Integer> ans) {
        if(root.left != null) {
            dfs(root.left, ans);
        }
        if(root.right != null) {
            dfs(root.right, ans);
        }
        ans.add(root.val);
    }
}

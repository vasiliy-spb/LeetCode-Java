package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.*;

// from walkccc.me (Approach 2: Iterative)
public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.left != null)
                stack.push(root.left);
            if (root.right != null)
                stack.push(root.right);
        }

        Collections.reverse(ans);
        return ans;
    }
}

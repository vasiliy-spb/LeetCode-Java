package matrix.workingPeoplesImitation.task_114_Flatten_Binary_Tree_to_Linked_List;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// from walkccc.me (Approach 2: Iterative (stack))
public class Solution3 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
            if (!stack.isEmpty())
                root.right = stack.peek();
            root.left = null;
        }
    }
}

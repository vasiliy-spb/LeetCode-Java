package matrix.workingPeoplesImitation.task_114_Flatten_Binary_Tree_to_Linked_List;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.Stack;

// my solution
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        if (root.right != null) {
            stack.push(root.right);
        }
        if (root.left != null) {
            stack.push(root.left);
        }
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            root.right = current;
            root.left = null;
            root = root.right;
        }
    }
}

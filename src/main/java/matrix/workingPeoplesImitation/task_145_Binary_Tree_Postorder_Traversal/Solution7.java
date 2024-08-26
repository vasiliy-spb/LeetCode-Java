package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;


import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// from leetcode editorial (Approach 4: Single Stack Postorder Traversal (Iterative))
public class Solution7 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // To keep track of the previously processed node
        TreeNode previousNode = null;
        // Stack to manage the traversal
        Stack<TreeNode> traversalStack = new Stack<>();

        // Process nodes until both the root is null and the stack is empty
        while (root != null || !traversalStack.isEmpty()) {
            // Traverse to the leftmost node
            if (root != null) {
                traversalStack.push(root);
                root = root.left;
            } else {
                // Peek at the top node of the stack
                root = traversalStack.peek();

                // If there is no right child or the right child was already processed
                if (root.right == null || root.right == previousNode) {
                    result.add(root.val);
                    traversalStack.pop();
                    previousNode = root;
                    root = null; // Ensure we don’t traverse again from this node
                } else {
                    // Move to the right child
                    root = root.right;
                }
            }
        }

        return result;
    }
}
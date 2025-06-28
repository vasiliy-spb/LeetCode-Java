package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;


import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// from leetcode editorial (Approach 3: Two Stack Postorder Traversal (Iterative))
public class Solution6 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // Stack to manage the traversal
        Stack<TreeNode> mainStack = new Stack<>();
        // Stack to manage the path
        Stack<TreeNode> pathStack = new Stack<>();

        // Start with the root node
        mainStack.push(root);

        // Process nodes until the main stack is empty
        while (!mainStack.isEmpty()) {
            root = mainStack.peek();

            // If the node is in the path stack and it's the top, add its value
            if (!pathStack.isEmpty() && pathStack.peek() == root) {
                result.add(root.val);
                mainStack.pop();
                pathStack.pop();
            } else {
                // Push the current node to the path stack
                pathStack.push(root);
                // Push right child if it exists
                if (root.right != null) {
                    mainStack.push(root.right);
                }
                // Push left child if it exists
                if (root.left != null) {
                    mainStack.push(root.left);
                }
            }
        }

        return result;
    }
}

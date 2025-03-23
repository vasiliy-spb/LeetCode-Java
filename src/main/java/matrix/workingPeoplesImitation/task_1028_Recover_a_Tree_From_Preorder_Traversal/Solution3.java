package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.Stack;

// from leetcode editorial (Approach 2: Iterative Approach with Stack (Single Pass))
public class Solution3 {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        while (index < traversal.length()) {
            // Count the number of dashes
            int depth = 0;
            while (
                    index < traversal.length() && traversal.charAt(index) == '-'
            ) {
                depth++;
                index++;
            }

            // Extract the node value
            int value = 0;
            while (
                    index < traversal.length() &&
                            Character.isDigit(traversal.charAt(index))
            ) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            // Create the current node
            TreeNode node = new TreeNode(value);

            // Adjust the stack to the correct depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach the node to the parent
            if (!stack.empty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push the current node onto the stack
            stack.push(node);
        }

        // The root is the first node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}

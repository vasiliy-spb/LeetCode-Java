package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode editorial (Approach 1: Brute Force (Recursive with String Manipulation))
public class Solution2 {
    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);
    }

    private TreeNode helper(String traversal, int depth) {
        if (index >= traversal.length()) return null;
        // Count the number of dashes
        int dashCount = 0;
        while (
                (index + dashCount) < traversal.length() &&
                        traversal.charAt(index + dashCount) == '-'
        ) {
            dashCount++;
        }

        // If the number of dashes doesn't match the current depth, return null
        if (dashCount != depth) return null;

        // Move index past the dashes
        index += dashCount;

        // Extract the node value
        int value = 0;
        while (
                index < traversal.length() &&
                        Character.isDigit(traversal.charAt(index))
        ) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        // Create the current node
        TreeNode node = new TreeNode(value);

        // Recursively build the left and right subtrees
        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }
}

package matrix.workingPeoplesImitation.task_145_Binary_Tree_Postorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach 5: Morris Traversal (No stack))
public class Solution8 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // Create a dummy node to simplify edge cases
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode predecessor = null;
        dummyNode.left = root;
        root = dummyNode;

        // Traverse the tree
        while (root != null) {
            // If the current node has a left child
            if (root.left != null) {
                predecessor = root.left;

                // Find the rightmost node in the left subtree or the thread to the current node
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // Create a thread if it doesn't exist
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // Process the nodes in the left subtree
                    TreeNode node = predecessor;
                    reverseSubtreeLinks(root.left, predecessor);

                    // Add nodes from right to left
                    while (node != root.left) {
                        result.add(node.val);
                        node = node.right;
                    }
                    result.add(node.val); // Add root.left value
                    reverseSubtreeLinks(predecessor, root.left);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // Move to the right child if there's no left child
                root = root.right;
            }
        }

        return result;
    }

    private void reverseSubtreeLinks(TreeNode startNode, TreeNode endNode) {
        if (startNode == endNode) {
            return; // If the start and end nodes are the same, no need to reverse
        }

        TreeNode prev = null;
        TreeNode current = startNode;
        TreeNode next = null;

        // Reverse the direction of the pointers in the subtree
        while (current != endNode) {
            next = current.right;
            current.right = prev;
            prev = current;
            current = next;
        }
        // Reverse the last node
        current.right = prev;
    }
}

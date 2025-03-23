package matrix.workingPeoplesImitation.task_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>(List.of(root));

        for (int i = 1; i < preorder.length; ++i) {
            TreeNode parent = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // Adjust the parent.
            while (!stack.isEmpty() && stack.peek().val < child.val) {
                parent = stack.pop();
            }
            // Create parent-child link according to BST property.
            if (parent.val > child.val) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            stack.push(child);
        }

        return root;
    }
}

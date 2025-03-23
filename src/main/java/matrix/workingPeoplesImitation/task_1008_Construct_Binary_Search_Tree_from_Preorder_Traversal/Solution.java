package matrix.workingPeoplesImitation.task_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.Stack;

// my solution
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            int num = preorder[i];
            if (stack.empty()) {
                stack.push(new TreeNode(num));
                continue;
            }
            TreeNode current = stack.pop();
            if (current.val > num) {
                while (!stack.empty() && num > stack.peek().val) {
                    current = stack.pop();
                }
                current.left = new TreeNode(num);
                stack.push(current);
                stack.push(current.left);
            } else {
                while (!stack.empty() && stack.peek().val < num) {
                    current = stack.pop();
                }
                current.right = new TreeNode(num);
                stack.push(current.right);
            }
        }
        return root;
    }
}

package matrix.workingPeoplesImitation.task_1339_Maximum_Product_of_Splitted_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

// my solution
public class Solution {
    public int maxProduct(TreeNode root) {
        int modulo = 1_000_000_007;

        calculateSubtreeSum(root);

        int totalSum = root.val;
        long maxProduct = 1;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            maxProduct = Math.max((long) (totalSum - current.val) * current.val, maxProduct);

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return (int) (maxProduct % modulo);
    }

    private int calculateSubtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val += calculateSubtreeSum(node.left) + calculateSubtreeSum(node.right);
        return node.val;
    }
}

package matrix.workingPeoplesImitation.tree_helper;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTestHelper {
    // собирает дерево из массива (если в массиве пропущены потомки нулевых (null) элементов)
    public static TreeNode buildTreeFromArray(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);

        for (int i = 1; i < array.length; i++) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }

            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
        }

        return root;
    }

    // Method to check if two trees are equivalent
    public static boolean areEquivalent(TreeNode root1, TreeNode root2) {
        // Base cases: If both trees are null, they are equivalent
        if (root1 == null && root2 == null) {
            return true;
        }

        // If one tree is null and the other is not, they are not equivalent
        if (root1 == null || root2 == null) {
            return false;
        }

        // Check if the values of current nodes are equal
        boolean valuesEqual = root1.val == root2.val;

        // Recursively check left and right subtrees
        boolean leftSubtreeEqual = areEquivalent(root1.left, root2.left);
        boolean rightSubtreeEqual = areEquivalent(root1.right, root2.right);

        // Two trees are equivalent if values are equal and left and right subtrees are equivalent
        return valuesEqual && leftSubtreeEqual && rightSubtreeEqual;
    }
}

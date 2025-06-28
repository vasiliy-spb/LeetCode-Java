package matrix.workingPeoplesImitation.task_700_Search_in_a_Binary_Search_Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer [] input = {4,2,7,1,3};
        TreeNode root = buildTreeFromArray(input);
        int val = 2;
        Integer [] output = {2,1,3};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.searchBST(root, val)));
    }

    @Test
    public void checkTestcase2() {
        Integer [] input = {4,2,7,1,3};
        TreeNode root = buildTreeFromArray(input);
        int val = 5;
        Integer [] output = {};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.searchBST(root, val)));
    }


    public TreeNode buildTreeFromArray(Integer[] array) {
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
    public boolean areEquivalent(TreeNode root1, TreeNode root2) {
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

package matrix.workingPeoplesImitation.task_450_Delete_Node_in_a_BST;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] input = {5, 3, 6, 2, 4, null, 7};
        TreeNode root = buildTreeFromArray(input);
        int key = 3;
        Integer[] output1 = {5, 4, 6, 2, null, null, 7};
        TreeNode expected1 = buildTreeFromArray(output1);
        Integer[] output2 = {5, 2, 6, null, 4, null, 7};
        TreeNode expected2 = buildTreeFromArray(output2);
        TreeNode result = testingClass.deleteNode(root, key);
        assertTrue(areEquivalent(expected1, result) || areEquivalent(expected2, result));
    }

    @Test
    public void checkTestcase2() {
        Integer[] input = {5, 3, 6, 2, 4, null, 7};
        TreeNode root = buildTreeFromArray(input);
        int key = 0;
        Integer[] output = {5, 3, 6, 2, 4, null, 7};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }

    @Test
    public void checkTestcase3() {
        Integer[] input = {};
        TreeNode root = buildTreeFromArray(input);
        int key = 0;
        Integer[] output = {};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }

    @Test
    public void checkTestcase4() { // 3 / 92 testcases passed
        Integer[] input = {0};
        TreeNode root = buildTreeFromArray(input);
        int key = 0;
        Integer[] output = {};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }

    @Test
    public void checkTestcase5() { // 63 / 92 testcases passed
        Integer[] input = {5, 3, 6, 2, 4, null, 7};
        TreeNode root = buildTreeFromArray(input);
        int key = 5;
        Integer[] output = {6, 3, 7, 2, 4};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }

    @Test
    public void checkTestcase6() { // 62 / 92 testcases passed
        Integer[] input = {1};
        TreeNode root = buildTreeFromArray(input);
        int key = 0;
        Integer[] output = {1};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }

    @Test
    public void checkTestcase7() { // 74 / 92 testcases passed
        Integer[] input = {50, 30, 70, null, 40, 60, 80};
        TreeNode root = buildTreeFromArray(input);
        int key = 50;
        Integer[] output = {60, 30, 70, null, 40, null, 80};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }
    /*
                 50,
             30,     70,
         null, 40, 60, 80
     */

    @Test
    public void checkTestcase8() { // 77 / 92 testcases passed
        Integer[] input = {4, null, 7, 6, 8, 5, null, null, 9};
        TreeNode root = buildTreeFromArray(input);
        int key = 7;
        Integer[] output = {4, null, 8, 6, 9, 5};
        TreeNode expected = buildTreeFromArray(output);
        assertTrue(areEquivalent(expected, testingClass.deleteNode(root, key)));
    }
    /*
                            4,
                     null,      7,
                            6,      8,
                        5, null, null, 9
     */

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

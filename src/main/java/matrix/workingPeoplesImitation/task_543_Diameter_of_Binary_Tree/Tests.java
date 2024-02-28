package matrix.workingPeoplesImitation.task_543_Diameter_of_Binary_Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] root = {1, 2, 3, 4, 5};
        int expected = 3;
        assertEquals(expected, testingClass.diameterOfBinaryTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase2() {
        Integer[] root = {1, 2};
        int expected = 1;
        assertEquals(expected, testingClass.diameterOfBinaryTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase3() { // 13 / 105 testcases passed
        Integer[] root = {1};
        int expected = 0;
        assertEquals(expected, testingClass.diameterOfBinaryTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase4() { // 9 / 105 testcases passed
        Integer[] root = {2, 3, null, 1};
        int expected = 2;
        assertEquals(expected, testingClass.diameterOfBinaryTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase5() { // 46 / 105 testcases passed
        Integer[] root = {3, 1, 2};
        int expected = 2;
        assertEquals(expected, testingClass.diameterOfBinaryTree(buildTreeFromArray(root)));
    }

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

}

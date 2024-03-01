package matrix.workingPeoplesImitation.task_1609_Even_Odd_Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] root = {1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2};
        assertTrue(testingClass.isEvenOddTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase2() {
        Integer[] root = {5, 4, 2, 3, 3, 7};
        assertFalse(testingClass.isEvenOddTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase3() {
        Integer[] root = {5, 9, 1, 3, 5, 7};
        assertFalse(testingClass.isEvenOddTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase4() { // 98 / 106 testcases passed
        Integer[] root = {2, 12, 8, 5, 9, null, null, 18, 16};
        assertFalse(testingClass.isEvenOddTree(buildTreeFromArray(root)));
    }

    @Test
    public void checkTestcase5() { // 105 / 106 testcases passed
        Integer[] root = {17, 46, 44, 17, null, 21, 23, null, null, 50, 48, 46, 44, 5, null, 7, null, 11, null, 13, null, null, null, null, null, null, null, 17};
        assertFalse(testingClass.isEvenOddTree(buildTreeFromArray(root)));
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

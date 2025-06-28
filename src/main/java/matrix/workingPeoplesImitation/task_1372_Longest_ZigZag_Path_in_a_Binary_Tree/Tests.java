package matrix.workingPeoplesImitation.task_1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

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

    @Test
    public void checkTestcase1() {
        Integer[] input = new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1};
        TreeNode root = buildTreeFromArray(input);

//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(1);
//        root.right.right.left = new TreeNode(1);
//        root.right.right.right = new TreeNode(1);
//        root.right.right.left.right = new TreeNode(1);
//        root.right.right.left.right.right = new TreeNode(1);

        int expected = 3;
        assertEquals(expected, testingClass.longestZigZag(root));
    }

    @Test
    public void checkTestcase2() {
        Integer[] input = new Integer[]{1, 1, 1, null, 1, null, null, 1, 1, null, 1};
        TreeNode root = buildTreeFromArray(input);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.left.right.left = new TreeNode(1);
//        root.left.right.right = new TreeNode(1);
//        root.left.right.left.right = new TreeNode(1);

        int expected = 4;
        assertEquals(expected, testingClass.longestZigZag(root));
    }

    @Test
    public void checkTestcase3() {
        Integer[] input = new Integer[]{};
        TreeNode root = buildTreeFromArray(input);
        int expected = 0;
        assertEquals(expected, testingClass.longestZigZag(root));
    }

    @Test
    public void checkTestcase4() { // 21 / 58 testcases passed
        Integer[] input = new Integer[]{6, 9, 7, 3, null, 2, 8, 5, 8, 9, 7, 3, 9, 9, 4, 2, 10, null, 5, 4, 3, 10, 10, 9, 4, 1, 2, null, null, 6, 5, null, null, null, null, 9, null, 9, 6, 5, null, 5, null, null, 7, 7, 4, null, 1, null, null, 3, 7, null, 9, null, null, null, null, null, null, null, null, 9, 9, null, null, null, 7, null, null, null, null, null, null, null, null, null, 6, 8, 7, null, null, null, 3, 10, null, null, null, null, null, 1, null, 1, 2};
        TreeNode root = buildTreeFromArray(input);
//        System.out.println("root = " + root);

        int expected = 5;
        assertEquals(expected, testingClass.longestZigZag(root));
    }


    public TreeNode createTree(Integer[] array) { // собирает дерево из массива (если в массиве присутствуют потомки нулевых (null) элементов)
        TreeNode[] tree = new TreeNode[array.length];
        int correctSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i + correctSum] == null) continue;
            TreeNode current = new TreeNode(array[i]);
            int indexLeft = (i + correctSum + 1) * 2 - 1;
            int indexRight = (i + correctSum + 1) * 2;
            if (indexLeft >= array.length) indexLeft = -1;
            if (indexRight >= array.length) indexRight = -1;
            if (indexLeft > 0 && array[indexLeft] != null) current.left = new TreeNode(array[indexLeft]);
            if (indexRight > 0 && array[indexRight] != null) current.right = new TreeNode(array[indexRight]);
            tree[i + correctSum] = current;
        }
        return tree[0];
    }

}

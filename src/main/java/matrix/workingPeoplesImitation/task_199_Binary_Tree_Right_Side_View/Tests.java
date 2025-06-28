package matrix.workingPeoplesImitation.task_199_Binary_Tree_Right_Side_View;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] input = new Integer[]{1, 2, 3, null, 5, null, 4};
        TreeNode root = buildTreeFromArray(input);
        List<Integer> expected = List.of(1, 3, 4);
        assertEquals(expected, testingClass.rightSideView(root));
    }

    @Test
    public void checkTestcase2() {
        Integer[] input = new Integer[]{1,null,3};
        TreeNode root = buildTreeFromArray(input);
        List<Integer> expected = List.of(1,3);
        assertEquals(expected, testingClass.rightSideView(root));
    }

    @Test
    public void checkTestcase3() {
        Integer[] input = new Integer[]{};
        TreeNode root = buildTreeFromArray(input);
        List<Integer> expected = List.of();
        assertEquals(expected, testingClass.rightSideView(root));
    }

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

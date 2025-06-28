package matrix.workingPeoplesImitation.task_112_Path_Sum;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        assertTrue(testingClass.hasPathSum(root, targetSum));
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int targetSum = 5;

        assertFalse(testingClass.hasPathSum(root, targetSum));
    }

    @Test
    public void checkTestcase3() {
        TreeNode root = null;

        int targetSum = 0;

        assertFalse(testingClass.hasPathSum(root, targetSum));
    }

}

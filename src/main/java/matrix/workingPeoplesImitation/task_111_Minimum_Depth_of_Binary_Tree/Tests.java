package matrix.workingPeoplesImitation.task_111_Minimum_Depth_of_Binary_Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int expected = 2;
        assertEquals(expected, testingClass.minDepth(root));
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);

        int expected = 5;
        assertEquals(expected, testingClass.minDepth(root));
    }

    @Test
    public void checkTestcase3() { // 9 / 53 testcases passed
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int expected = 2;
        assertEquals(expected, testingClass.minDepth(root));
    }

}

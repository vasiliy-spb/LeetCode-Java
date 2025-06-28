package matrix.workingPeoplesImitation.task_104_Maximum_Depth_of_Binary_Tree;

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

        int expected = 3;
        assertEquals(expected, testingClass.maxDepth(root));
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        int expected = 2;
        assertEquals(expected, testingClass.maxDepth(root));
    }

    @Test
    public void checkTestcase3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(4);
        root.right.left.left.right = new TreeNode(2);
        root.right.left.left.right.left = new TreeNode(23);

        int expected = 6;
        assertEquals(expected, testingClass.maxDepth(root));
    }

    @Test
    public void checkTestcase4() { // 2 / 39 testcases passed
        TreeNode root = null;

        int expected = 0;
        assertEquals(expected, testingClass.maxDepth(root));
    }

}

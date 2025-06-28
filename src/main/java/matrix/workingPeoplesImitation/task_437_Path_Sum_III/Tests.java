package matrix.workingPeoplesImitation.task_437_Path_Sum_III;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        TreeNode root = new TreeNode(10); // [10,5,-3,3,2,null,11,3,-2,null,1]
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int expected = 3;
        assertEquals(expected, testingClass.pathSum(root, targetSum));
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(5); // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        int expected = 3;
        assertEquals(expected, testingClass.pathSum(root, targetSum));
    }

    @Test
    public void checkTestcase3() { // 116 / 128 testcases passed
        TreeNode root = new TreeNode(0); // [0,1,1]
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        int targetSum = 1;
        int expected = 4;
        assertEquals(expected, testingClass.pathSum(root, targetSum));
    }

    @Test
    public void checkTestcase4() { // 127 / 128 testcases passed
        TreeNode root = new TreeNode(1000000000); // [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);

        int targetSum = 0;
        int expected = 0;
        assertEquals(expected, testingClass.pathSum(root, targetSum));
    }

}

package matrix.workingPeoplesImitation.task_1448_Count_Good_Nodes_in_Binary_Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int expected = 4;
        assertEquals(expected, testingClass.goodNodes(root));
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int expected = 3;
        assertEquals(expected, testingClass.goodNodes(root));
    }

    @Test
    public void checkTestcase3() {
        TreeNode root = new TreeNode(1);

        int expected = 1;
        assertEquals(expected, testingClass.goodNodes(root));
    }

    @Test
    public void checkTestcase4() { // [2,null,4,10,8,null,null,4] — 5 / 63 testcases passed
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(4);

        int expected = 4;
        assertEquals(expected, testingClass.goodNodes(root));
    }
                                                        /*
                                                        2
                                                null          4
                                                        10         8
                                                    null  null         4
                                                 */

}

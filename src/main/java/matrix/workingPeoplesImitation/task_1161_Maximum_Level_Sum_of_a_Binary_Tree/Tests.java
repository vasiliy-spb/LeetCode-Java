package matrix.workingPeoplesImitation.task_1161_Maximum_Level_Sum_of_a_Binary_Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() { // [1,7,0,7,-8,null,null]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int expected = 2;

        assertEquals(expected, testingClass.maxLevelSum(root));
    }

    @Test
    public void checkTestcase2() { // [989,null,10250,98693,-89388,null,null,null,-32127]
        TreeNode root = new TreeNode(989);
        root.right = new TreeNode(10250);
        root.right.left = new TreeNode(98693);
        root.right.right = new TreeNode(-89388);
        root.right.right.right = new TreeNode(-32127);

        int expected = 2;

        assertEquals(expected, testingClass.maxLevelSum(root));
    }

}

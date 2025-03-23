package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;
import org.junit.jupiter.api.Test;

import static matrix.workingPeoplesImitation.tree_helper.BinaryTreeTestHelper.areEquivalent;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String traversal = "1-2--3--4-5--6--7";
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(3);
        expected.left.right = new TreeNode(4);
        expected.right = new TreeNode(5);
        expected.right.left = new TreeNode(6);
        expected.right.right = new TreeNode(7);
        assertTrue(areEquivalent(expected, testingClass.recoverFromPreorder(traversal)));
    }

    @Test
    public void checkTestcase02() {
        String traversal = "1-2--3---4-5--6---7";
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.left.left = new TreeNode(3);
        expected.left.left.left = new TreeNode(4);
        expected.right = new TreeNode(5);
        expected.right.left = new TreeNode(6);
        expected.right.left.left = new TreeNode(7);
        assertTrue(areEquivalent(expected, testingClass.recoverFromPreorder(traversal)));
    }

    @Test
    public void checkTestcase03() {
        String traversal = "1-401--349---90--88";
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(401);
        expected.left.left = new TreeNode(349);
        expected.left.left.left = new TreeNode(90);
        expected.left.right = new TreeNode(88);
        assertTrue(areEquivalent(expected, testingClass.recoverFromPreorder(traversal)));
    }

    @Test
    public void checkTestcase04() {
        String traversal = "3";
        TreeNode expected = new TreeNode(3);
        assertTrue(areEquivalent(expected, testingClass.recoverFromPreorder(traversal)));
    }

    @Test
    public void checkTestcase05() {
        String traversal = "3-5";
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(5);
        assertTrue(areEquivalent(expected, testingClass.recoverFromPreorder(traversal)));
    }
}

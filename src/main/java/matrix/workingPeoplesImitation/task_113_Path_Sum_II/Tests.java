package matrix.workingPeoplesImitation.task_113_Path_Sum_II;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testPathSumExample1() {
        TreeNode root = buildTreeExample1();
        int targetSum = 22;

        List<List<Integer>> result = testingClass.pathSum(root, targetSum);

        assertEquals(2, result.size());
        assertEquals(List.of(5, 4, 11, 2), result.get(0));
        assertEquals(List.of(5, 8, 4, 5), result.get(1));
    }

    @Test
    public void testPathSumExample2() {
        TreeNode root = buildTreeExample2();
        int targetSum = 5;

        List<List<Integer>> result = testingClass.pathSum(root, targetSum);

        assertEquals(0, result.size());
    }

    @Test
    public void testPathSumExample3() {
        TreeNode root = buildTreeExample3();
        int targetSum = 0;

        List<List<Integer>> result = testingClass.pathSum(root, targetSum);

        assertEquals(0, result.size());
    }

    // Helper method to build the tree for Example 1
    private TreeNode buildTreeExample1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        return root;
    }

    // Helper method to build the tree for Example 2
    private TreeNode buildTreeExample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    // Helper method to build the tree for Example 3
    private TreeNode buildTreeExample3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }
}

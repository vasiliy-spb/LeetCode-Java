package matrix.workingPeoplesImitation.task_2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another;

import matrix.workingPeoplesImitation.tree_helper.BinaryTreeTestHelper;
import matrix.workingPeoplesImitation.tree_helper.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        Integer[] root = {5,1,2,3,null,6,4};
        int startValue = 3;
        int destValue = 6;
        TreeNode tree = BinaryTreeTestHelper.buildTreeFromArray(root);
        String expected = "UURL";
        assertEquals(expected, testingClass.getDirections(tree, startValue, destValue));
    }

    @Test
    public void checkTestcase02() {
        Integer[] root = {2,1};
        int startValue = 2;
        int destValue = 1;
        TreeNode tree = BinaryTreeTestHelper.buildTreeFromArray(root);
        String expected = "L";
        assertEquals(expected, testingClass.getDirections(tree, startValue, destValue));
    }

    @Test
    public void checkTestcase03() {
        Integer[] root = {5, 8, 3, 1, null, 4, 7, 6, null, null, null, null, null, null, 2};
        int startValue = 5;
        int destValue = 6;
        TreeNode tree = BinaryTreeTestHelper.buildTreeFromArray(root);
        String expected = "LLL";
        assertEquals(expected, testingClass.getDirections(tree, startValue, destValue));
    }

    @Test
    public void checkTestcase04() {
        Integer[] root = {1,null,10,12,13,4,6,null,15,null,null,5,11,null,2,14,7,null,8,null,null,null,9,3};
        int startValue = 6;
        int destValue = 15;
        TreeNode tree = BinaryTreeTestHelper.buildTreeFromArray(root);
        String expected = "UURR";
        assertEquals(expected, testingClass.getDirections(tree, startValue, destValue));
    }

    @Test
    public void checkTestcase05() {
        Integer[] root = {5,8,3,1,null,4,7,6,null,null,null,null,null,null,2};
        int startValue = 4;
        int destValue = 3;
        TreeNode tree = BinaryTreeTestHelper.buildTreeFromArray(root);
        String expected = "U";
        assertEquals(expected, testingClass.getDirections(tree, startValue, destValue));
    }
    
}

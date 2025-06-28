package matrix.workingPeoplesImitation.task_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() { // [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        int expected = 3;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    public void checkTestcase2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        int expected = 5;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    public void checkTestcase3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        int expected = 1;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    public void checkTestcase4() { // [-1,0,3,-2,4,null,null,8] — 26 / 32 testcases passed
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);

        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(4);
        int expected = 0;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }
    /*
                                         -1
                                        0   3
                                      -2  4
                                     8
     */

    @Test
    public void checkTestcase5() { // [37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8] — // 26 / 32 testcases passed
        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(-34);
        root.right = new TreeNode(-48);
        root.left.right = new TreeNode(-100);
        root.right.left = new TreeNode(-101);
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(-54);
        root.right.right.left.left = new TreeNode(-71);
        root.right.right.left.right = new TreeNode(-22);
        root.right.right.left.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(-71);
        TreeNode q = new TreeNode(48);
        int expected = 48;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }
    // 37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8
    /*
                                       37
                           -34                           -48
                      null     -100             -101            48
                            null    null    null    null    -54     null
                                                      -71         -22
                                                  null   null   null    8

     */

    @Test
    public void checkTestcase6() { // [37,-34,-48,null,-100,-101,48,null,null,null,null,-54,null,-71,-22,null,null,null,8] — 31 / 32 testcases passed
        TreeNode root = new TreeNode(37);
        root.left = new TreeNode(-34);
        root.right = new TreeNode(-48);
        root.left.right = new TreeNode(-100);
        root.right.left = new TreeNode(-101);
        root.right.right = new TreeNode(48);
        root.right.right.left = new TreeNode(-54);
        root.right.right.left.left = new TreeNode(-71);
        root.right.right.left.right = new TreeNode(-22);
        root.right.right.left.right.right = new TreeNode(8);

        TreeNode p = new TreeNode(-71);
        TreeNode q = new TreeNode(8);
        int expected = -54;

        assertEquals(expected, testingClass.lowestCommonAncestor(root, p, q).val);
    }

}

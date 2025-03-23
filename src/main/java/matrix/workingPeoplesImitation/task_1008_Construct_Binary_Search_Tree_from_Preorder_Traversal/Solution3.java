package matrix.workingPeoplesImitation.task_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.Arrays;

// from leetcode code sample (1)
public class Solution3 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int index = 1;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < root.val) {
                index++;
            }
        }
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, index));
        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, index, preorder.length));
        return root;
    }
}

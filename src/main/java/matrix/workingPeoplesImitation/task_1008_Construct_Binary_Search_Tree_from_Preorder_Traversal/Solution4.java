package matrix.workingPeoplesImitation.task_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (2)
public class Solution4 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder, 0, preorder.length - 1);
    }

    public TreeNode createBST(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int mid = start + 1;
        while (mid <= end) {
            if (preorder[mid] < preorder[start]) {
                mid += 1;
            } else {
                break;
            }
        }
        node.left = createBST(preorder, start + 1, mid - 1);
        node.right = createBST(preorder, mid, end);
        return node;
    }
}

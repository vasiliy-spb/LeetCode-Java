package matrix.workingPeoplesImitation.task_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (3)
public class Solution5 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return call(preorder, new int[1], Integer.MAX_VALUE);
    }

    TreeNode call(int[] pre, int[] i, int bound) {
        if (i[0] == pre.length || pre[i[0]] >= bound) {
            return null;
        }
        TreeNode node = new TreeNode(pre[i[0]++]);
        node.left = call(pre, i, node.val);
        node.right = call(pre, i, bound);
        return node;
    }
}

package matrix.workingPeoplesImitation.task_1339_Maximum_Product_of_Splitted_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (2)
public class Solution4 {
    long total = 0L;
    long maxProd = 0L;

    public int maxProduct(TreeNode root) {
        this.total = sum(root);
        sum(root);
        return (int) (maxProd % 1_000_000_007L);
    }

    private long sum(TreeNode node) {
        if (node == null) {
            return 0L;
        }

        long sub = node.val + sum(node.left) + sum(node.right);

        maxProd = Math.max(maxProd, (total - sub) * sub);

        return sub;
    }
}

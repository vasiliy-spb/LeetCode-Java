package matrix.workingPeoplesImitation.task_1339_Maximum_Product_of_Splitted_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public int maxProduct(TreeNode root) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        List<Integer> allSums = new ArrayList<>();
        final long totalSum = treeSum(root, allSums);

        for (final long sum : allSums) {
            ans = Math.max(ans, sum * (totalSum - sum));
        }

        return (int) (ans % MOD);
    }

    private int treeSum(TreeNode root, List<Integer> allSums) {
        if (root == null) {
            return 0;
        }

        final int leftSum = treeSum(root.left, allSums);
        final int rightSum = treeSum(root.right, allSums);
        final int sum = root.val + leftSum + rightSum;
        allSums.add(sum);
        return sum;
    }
}

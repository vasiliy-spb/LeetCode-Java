package matrix.workingPeoplesImitation.task_1339_Maximum_Product_of_Splitted_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (3)
public class Solution5 {
    public int maxProduct(TreeNode root) {
        //calculate total sum
        long totalSum = calculateSum(root);

        // Using array as we need to update the answer and variables are passed by value in java methods.
        // Alternate is making a wrapper class for our answer and then pass as objects are passed by reference.
        //Using static variable should be avoided as in multiple test case, previous global answer can interfere with another test case
        long[] ans = {0};
        int mod = 1_000_000_007;

        //main solve function
        solve(root, totalSum, ans);

        //mod the global answer
        return (int) (ans[0] % mod);
    }

    /**
     * Finds the total sum of the binary tree
     *
     * @param root The node of the binary tree.
     * @return The sum of the subtree upto root
     */
    static long calculateSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + calculateSum(root.left) + calculateSum(root.right);
    }

    /**
     * Util Function to update the global answer
     *
     * @param root     The node of the binary tree.
     * @param totalSum The total Sum of the binary tree.
     * @param ans      Our global answer
     * @return The sum of the subtree with updating the global answer
     */
    static long solve(TreeNode root, long totalSum, long[] ans) {
        if (root == null)
            return 0;
        //sum of left-subtree
        long left = solve(root.left, totalSum, ans);
        //sum of right-subtree
        long right = solve(root.right, totalSum, ans);

        //intermediate sum
        long temp = left + right + root.val;
        //product of splitted trees
        long intermediateAnswer = temp * (totalSum - temp);
        //updating global answer
        ans[0] = Math.max(ans[0], intermediateAnswer);
        return temp;
    }
}

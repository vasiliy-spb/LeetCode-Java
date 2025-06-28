package matrix.workingPeoplesImitation.task_129_Sum_Root_to_Leaf_Numbers;

public class Solution {

    // my solution
    public int sumNumbers(TreeNode root) {
        int[] ans = new int[1];
        sumAllPath(root, ans, 0);
        return ans[0];
    }

    public void sumAllPath(TreeNode root, int[] ans, int sum) {
        sum *= 10;
        sum += root.val;
        if (root.left == null && root.right == null) {
            ans[0] += sum;
            return;
        }
        if (root.left != null) sumAllPath(root.left, ans, sum);
        if (root.right != null) sumAllPath(root.right, ans, sum);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
package matrix.workingPeoplesImitation.task_543_Diameter_of_Binary_Tree;

public class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        findDistance(root,ans);
        return ans[0];
    }

    private int findDistance(TreeNode root, int[] ans) {
        if (root == null) return 0;

        int left = findDistance(root.left, ans);
        int right = findDistance(root.right, ans);
        ans[0] = Math.max(ans[0], left + right);

        return Math.max(left, right) + 1;
    }


    public int diameterOfBinaryTree2(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
//        return dfs(root) - 1;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int diameter = left + right;
        return Math.max(Math.max(left, right), diameter);
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
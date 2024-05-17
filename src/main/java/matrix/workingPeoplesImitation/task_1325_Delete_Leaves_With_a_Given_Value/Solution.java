package matrix.workingPeoplesImitation.task_1325_Delete_Leaves_With_a_Given_Value;


public class Solution {

    // my solution
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target && root.left == null && root.right == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) root = null;
        return root;
    }

    // from walkccc.me
    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes2(root.left, target);
        root.right = removeLeafNodes2(root.right, target);
        return isLeaf(root) && root.val == target ? null : root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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
}

package matrix.workingPeoplesImitation.task_654_Maximum_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me
public class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int i, int j) {
        if (i > j)
            return null;

        int maxIndex = i;
        for (int k = i + 1; k <= j; ++k)
            if (nums[k] > nums[maxIndex])
                maxIndex = k;

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, i, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, j);
        return root;
    }
}

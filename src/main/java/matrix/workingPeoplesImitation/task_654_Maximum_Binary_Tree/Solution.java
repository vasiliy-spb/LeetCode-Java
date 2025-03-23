package matrix.workingPeoplesImitation.task_654_Maximum_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// my solution
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums, 0, nums.length);
    }

    private TreeNode constructTree(int[] nums, int start, int finish) {
        if (start >= finish) {
            return null;
        }
        int max = -1;
        int indexMax = -1;
        for (int i = start; i < finish; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexMax = i;
            }
        }
        TreeNode current = new TreeNode(max);
        current.left = constructTree(nums, start, indexMax);
        current.right = constructTree(nums, indexMax + 1, finish);
        return current;
    }
}

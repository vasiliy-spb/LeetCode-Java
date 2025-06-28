package matrix.workingPeoplesImitation.task_2583_Kth_Largest_Sum_in_a_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.*;

// my solution
public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> sums = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            sums.add(levelSum);
        }
        if (sums.size() < k) {
            return -1;
        }
        while (k-- > 1) {
            sums.poll();
        }
        return sums.peek();
    }
}

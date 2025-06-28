package matrix.workingPeoplesImitation.task_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// my solution
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (ans.size() % 2 == 1) {
                    level.add(0, current.val);
                } else {
                    level.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}

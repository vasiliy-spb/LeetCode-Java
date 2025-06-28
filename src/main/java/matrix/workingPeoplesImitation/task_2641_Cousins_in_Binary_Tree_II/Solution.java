package matrix.workingPeoplesImitation.task_2641_Cousins_in_Binary_Tree_II;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// my solution
public class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levels = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
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
            levels.add(levelSum);
        }
        queue.offer(root);
        Queue<TreeNode> ansQueue = new ArrayDeque<>();
        TreeNode ans = new TreeNode(0);
        ansQueue.offer(ans);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int nextLevelSum = -1;
            if (levels.size() > level) {
                nextLevelSum = levels.get(level);
            }
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                TreeNode ansCurrent = ansQueue.poll();
                if (nextLevelSum < 0) {
                    if (current.left != null) {
                        ansCurrent.left = new TreeNode(0);
                        queue.offer(current.left);
                        ansQueue.offer(ansCurrent.left);
                    }
                    if (current.right != null) {
                        ansCurrent.right = new TreeNode(0);
                        queue.offer(current.right);
                        ansQueue.offer(ansCurrent.right);
                    }
                    continue;
                }
                if (current.left != null) {
                    int value = nextLevelSum - current.left.val;
                    if (current.right != null) {
                        value -= current.right.val;
                    }
                    ansCurrent.left = new TreeNode(value);
                    queue.offer(current.left);
                    ansQueue.offer(ansCurrent.left);
                }
                if (current.right != null) {
                    int value = nextLevelSum - current.right.val;
                    if (current.left != null) {
                        value -= current.left.val;
                    }
                    ansCurrent.right = new TreeNode(value);
                    queue.offer(current.right);
                    ansQueue.offer(ansCurrent.right);
                }
            }
            level++;
        }
        return ans;
    }
}

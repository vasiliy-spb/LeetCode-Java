package matrix.workingPeoplesImitation.task_1161_Maximum_Level_Sum_of_a_Binary_Tree;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    // my solution
    public int maxLevelSum(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int maxSumLevel = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            if (maxSum < levelSum) {
                maxSum = levelSum;
                maxSumLevel = level;
            }
        }
        return maxSumLevel;
    }

    // from walkccc.me (Approach 1: BFS)
    public int maxLevelSum2(TreeNode root) {
        int ans = 1;
        int maxLevelSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

        for (int level = 1; !q.isEmpty(); ++level) {
            int levelSum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                levelSum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            if (maxLevelSum < levelSum) {
                maxLevelSum = levelSum;
                ans = level;
            }
        }

        return ans;
    }

    // from walkccc.me (Approach 2: DFS)
    public int maxLevelSum3(TreeNode root) {
        // levelSums[i] := the sum of level (i + 1) (1-indexed)
        List<Integer> levelSums = new ArrayList<>();
        dfs(root, 0, levelSums);
        return 1 + IntStream.range(0, levelSums.size())
                .reduce(0, (a, b) -> levelSums.get(a) < levelSums.get(b) ? b : a);
    }

    private void dfs(TreeNode root, int level, List<Integer> levelSums) {
        if (root == null)
            return;
        if (levelSums.size() == level)
            levelSums.add(0);
        levelSums.set(level, levelSums.get(level) + root.val);
        dfs(root.left, level + 1, levelSums);
        dfs(root.right, level + 1, levelSums);
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
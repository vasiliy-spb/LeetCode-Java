package matrix.workingPeoplesImitation.task_1448_Count_Good_Nodes_in_Binary_Tree;

import java.util.*;

public class Solution {

    // my solution
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int goodNodesCount = 0;
        Map<TreeNode, Integer> maxParentMap = new HashMap<>();
        maxParentMap.put(root, root.val);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val >= maxParentMap.get(current)) goodNodesCount++;
            maxParentMap.put(current, Math.max(maxParentMap.get(current),current.val));
            if (current.left != null) {
                queue.offer(current.left);
                maxParentMap.put(current.left, Math.max(maxParentMap.get(current), current.left.val));
            }
            if (current.right != null) {
                queue.offer(current.right);
                maxParentMap.put(current.right, Math.max(maxParentMap.get(current), current.right.val));
            }
        }
        return goodNodesCount;
    }

    // from walkccc.me
    public int goodNodes2(TreeNode root) {
        return goodNodes2(root, Integer.MIN_VALUE);
    }

    private int goodNodes2(TreeNode root, int max) {
        if (root == null)
            return 0;

        final int newMax = Math.max(max, root.val);
        return (root.val >= max ? 1 : 0) + goodNodes2(root.left, newMax) + goodNodes2(root.right, newMax);
    }

    // from leetcode solutions
    public int goodNodes3(TreeNode root) {
        return goodNodes3(root, -10000);
    }

    public int goodNodes3(TreeNode root, int ma) {
        if (root == null) return 0;
        int res = root.val >= ma ? 1 : 0;
        res += goodNodes3(root.left, Math.max(ma, root.val));
        res += goodNodes3(root.right, Math.max(ma, root.val));
        return res;
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

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
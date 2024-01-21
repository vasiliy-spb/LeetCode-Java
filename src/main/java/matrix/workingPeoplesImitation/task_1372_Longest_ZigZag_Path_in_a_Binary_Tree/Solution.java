package matrix.workingPeoplesImitation.task_1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        int maxZigZag = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                maxZigZag = Math.max(maxZigZag, zigzag(current.left, true));
            }
            if (current.right != null) {
                queue.offer(current.right);
                maxZigZag = Math.max(maxZigZag, zigzag(current.right, false));
            }
        }
        return maxZigZag;
    }

    public int zigzag(TreeNode current, boolean isLeft) {
        int count = 0;
        while (current != null) {
            count++;
            if (isLeft) current = current.right;
            else current = current.left;
            isLeft = !isLeft;
        }
        return count;
    }

    // my solution (success with checkTestcase 1-3)
    public int longestZigZag2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int leftZigZag = root.left == null ? 0 : calculateZigZag(root.left, true);
        int rightZigZag = root.right == null ? 0 : calculateZigZag(root.right, false);
        return Math.max (leftZigZag, rightZigZag);
    }

    public int calculateZigZag(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left;
        if (root.left != null) {
            left = isLeft ? calculateZigZag(root.left, true) : calculateZigZag(root.left, true) + 1;
        } else {
            left = 0;
        }

        int right;
        if (root.right != null) {
            right = !isLeft ? calculateZigZag(root.right, false) : calculateZigZag(root.right, false) + 1;
        } else {
            right = 0;
        }

        return Math.max(right, left);
    }

    // from leetcode editorial
    int pathLength = 0;
    private void dfs1(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfs1(node.left, false, steps + 1);
            dfs1(node.right, true, 1);
        } else {
            dfs1(node.left, false, 1);
            dfs1(node.right, true, steps + 1);
        }
    }

    public int longestZigZag3(TreeNode root) {
        dfs1(root, false, 0);
        dfs1(root, true, 0);
        return pathLength;
    }

    // from walkccc.me
    public int longestZigZag4(TreeNode root) {
        return dfs2(root).subtreeMax;
    }

    private T dfs2(TreeNode root) {
        if (root == null)
            return new T(-1, -1, -1);
        T left = dfs2(root.left);
        T right = dfs2(root.right);
        final int leftZigZag = left.rightMax + 1;
        final int rightZigZag = right.leftMax + 1;
        final int subtreeMax =
                Math.max(Math.max(leftZigZag, rightZigZag), Math.max(left.subtreeMax, right.subtreeMax));
        return new T(leftZigZag, rightZigZag, subtreeMax);
    }

    class T {
        public int leftMax;
        public int rightMax;
        public int subtreeMax;

        public T(int leftMax, int rightMax, int subtreeMax) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.subtreeMax = subtreeMax;
        }
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
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) result.append("null");
            else result.append(current.val);
            result.append(" — ");
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return result.toString();
    }
}
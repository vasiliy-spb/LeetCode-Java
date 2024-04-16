package matrix.workingPeoplesImitation.task_623_Add_One_Row_to_Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

    // my solution
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ans = new TreeNode(val, root, null);
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (depth - level > 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            level++;
        }
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = null;
            TreeNode right = null;
            if (current.left != null) left = current.left;
            if (current.right != null) right = current.right;
            current.left = new TreeNode(val, left, null);
            current.right = new TreeNode(val, null, right);
        }
        return root;
    }

    // from walkccc.me
    public TreeNode addOneRow2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        int depth = 0;
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));

        while (!q.isEmpty()) {
            ++depth;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                if (depth == d - 1) {
                    TreeNode cachedLeft = node.left;
                    TreeNode cachedRight = node.right;
                    node.left = new TreeNode(v);
                    node.right = new TreeNode(v);
                    node.left.left = cachedLeft;
                    node.right.right = cachedRight;
                }
            }
            if (depth == d - 1)
                break;
        }

        return root;
    }

    // from leetcode solutions (https://leetcode.com/problems/add-one-row-to-tree/solutions/5029902/faster-lesser-detailed-explaination-dfs-step-by-step-explaination-python-java/?envType=daily-question&envId=2024-04-16)
    public TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = lTemp;
            root.right.right = rTemp;

            return root;
        }

        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }

    public TreeNode addOneRow3(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return add(root, val, depth, 1);
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
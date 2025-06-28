package matrix.workingPeoplesImitation.task_112_Path_Sum;

import java.util.*;

public class Solution {

    // my solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sumMap.merge(current, current.val, Integer::sum);
            if (current.left == null && current.right == null && sumMap.get(current) == targetSum) return true;

            if (current.left != null) {
                queue.offer(current.left);
                sumMap.merge(current.left, sumMap.get(current), Integer::sum);
            }
            if (current.right != null) {
                queue.offer(current.right);
                sumMap.merge(current.right, sumMap.get(current), Integer::sum);
            }
        }
        return false;
    }

    // from walkccc.me
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum2(root.left, sum - root.val) ||
                hasPathSum2(root.right, sum - root.val);
    }

    // from GPT (use a breadth-first search (BFS) algorithm)
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            // Empty tree, no root-to-leaf paths
            return false;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        // Enqueue the root node and its corresponding sum
        nodeQueue.offer(root);
        sumQueue.offer(root.val);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            int currentSum = sumQueue.poll();

            // Check if the current node is a leaf
            if (currentNode.left == null && currentNode.right == null) {
                // If the current node is a leaf, check if its value equals the targetSum
                if (currentSum == targetSum) {
                    return true;
                }
            }

            // Enqueue left child and update the sum
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                sumQueue.offer(currentSum + currentNode.left.val);
            }

            // Enqueue right child and update the sum
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                sumQueue.offer(currentSum + currentNode.right.val);
            }
        }

        // No root-to-leaf path found with the target sum
        return false;
    }

    // from GPT (implement a depth-first search (DFS) algorithm)


    // from GPT (use a recursive approach)
    public boolean hasPathSum4(TreeNode root, int targetSum) {
        // Base case: if the root is null, there is no path.
        if (root == null) {
            return false;
        }

        // Check if the current node is a leaf and if the target sum is achieved.
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        // Recursively check the left and right subtrees.
        return hasPathSum4(root.left, targetSum - root.val) || hasPathSum4(root.right, targetSum - root.val);
    }

    // from GPT (implement a non-recursive depth-first search (DFS) using a stack)
    public boolean hasPathSum5(TreeNode root, int targetSum) {
        if (root == null) {
            // Empty tree, no root-to-leaf paths
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        // Push the root node and its corresponding sum onto the stacks
        nodeStack.push(root);
        sumStack.push(root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            int currentSum = sumStack.pop();

            // Check if the current node is a leaf
            if (currentNode.left == null && currentNode.right == null) {
                // If the current node is a leaf, check if its value equals the targetSum
                if (currentSum == targetSum) {
                    return true;
                }
            }

            // Push right child and update the sum
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                sumStack.push(currentSum + currentNode.right.val);
            }

            // Push left child and update the sum
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                sumStack.push(currentSum + currentNode.left.val);
            }
        }

        // No root-to-leaf path found with the target sum
        return false;
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
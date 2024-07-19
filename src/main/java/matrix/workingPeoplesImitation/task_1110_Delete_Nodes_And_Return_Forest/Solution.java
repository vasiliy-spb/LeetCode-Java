package matrix.workingPeoplesImitation.task_1110_Delete_Nodes_And_Return_Forest;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // my solution
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                map.put(current.val, current);
                if (current.left != null) {
                    queue.offer(current.left);
                    parents.put(current.left, current);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    parents.put(current.right, current);
                }
            }
        }
        Map<Integer, TreeNode> resultMap = new HashMap<>();
        resultMap.put(root.val, root);
        for (int del : to_delete) {
            TreeNode current = map.get(del);
            if (resultMap.containsKey(current.val)) {
                current = resultMap.remove(del);
            } else {
                current = map.get(del);
            }
            if (current.left != null) {
                resultMap.put(current.left.val, current.left);
            }
            if (current.right != null) {
                resultMap.put(current.right.val, current.right);
            }
            TreeNode parent = parents.get(current);
            if (parent == null) continue;
            if (parent.left == current) {
                parent.left = null;
            }
            if (parent.right == current) {
                parent.right = null;
            }
        }
        return resultMap.values().stream().toList();
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

    // from leetcode editorial (Approach 1: Recursion (Postorder Traversal))
    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        List<TreeNode> forest = new ArrayList<>();

        root = processNode(root, toDeleteSet, forest);

        // If the root is not deleted, add it to the forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode processNode(
            TreeNode node,
            Set<Integer> toDeleteSet,
            List<TreeNode> forest
    ) {
        if (node == null) {
            return null;
        }

        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        // Node Evaluation: Check if the current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // If the node has left or right children, add them to the forest
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            // Return null to its parent to delete the current node
            return null;
        }

        return node;
    }

    // from leetcode editorial (Approach 2: BFS Forest Formation)
    public List<TreeNode> delNodes3(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        List<TreeNode> forest = new ArrayList<>();

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            TreeNode currentNode = nodesQueue.poll();

            if (currentNode.left != null) {
                nodesQueue.add(currentNode.left);
                // Disconnect the left child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.left.val)) {
                    currentNode.left = null;
                }
            }

            if (currentNode.right != null) {
                nodesQueue.add(currentNode.right);
                // Disconnect the right child if it needs to be deleted
                if (toDeleteSet.contains(currentNode.right.val)) {
                    currentNode.right = null;
                }
            }

            // If the current node needs to be deleted, add its non-null children to the forest
            if (toDeleteSet.contains(currentNode.val)) {
                if (currentNode.left != null) {
                    forest.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    forest.add(currentNode.right);
                }
            }
        }

        // Ensure the root is added to the forest if it is not to be deleted
        if (!toDeleteSet.contains(root.val)) {
            forest.add(root);
        }

        return forest;
    }

    // from walkccc.me
    public List<TreeNode> delNodes4(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> toDeleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        dfs(root, toDeleteSet, true, ans);
        return ans;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, boolean isRoot,
                         List<TreeNode> ans) {
        if (root == null)
            return null;

        final boolean deleted = toDeleteSet.contains(root.val);
        if (isRoot && !deleted)
            ans.add(root);

        // If root is deleted, both children have the possibility to be a new root
        root.left = dfs(root.left, toDeleteSet, deleted, ans);
        root.right = dfs(root.right, toDeleteSet, deleted, ans);
        return deleted ? null : root;
    }
}

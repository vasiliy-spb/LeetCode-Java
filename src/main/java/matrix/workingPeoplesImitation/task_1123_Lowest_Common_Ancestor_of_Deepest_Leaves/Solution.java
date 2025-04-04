package matrix.workingPeoplesImitation.task_1123_Lowest_Common_Ancestor_of_Deepest_Leaves;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.*;

// my solution
public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Map<TreeNode, Integer> nodeLevels = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        List<TreeNode> leafs = new ArrayList<>();
        int deepestLevel = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                nodeLevels.put(current, level);
                deepestLevel = Math.max(deepestLevel, level);
                if (current.left == null && current.right == null) {
                    leafs.add(current);
                }
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
        List<TreeNode> deepestLeafs = getLeafs(leafs, deepestLevel, nodeLevels);

        if (deepestLeafs.size() == 1) {
            TreeNode current = deepestLeafs.get(0);
            return current;
        }

        TreeNode lca = null;
        for (TreeNode current : deepestLeafs) {
            TreeNode currentLca = getLca(current, deepestLeafs, parents, nodeLevels);
            if (lca == null) {
                lca = currentLca;
            } else if (nodeLevels.get(currentLca) < nodeLevels.get(lca)) {
                lca = currentLca;
            }
        }
        return lca;
    }

    private TreeNode getLca(TreeNode current, List<TreeNode> deepestLeafs, Map<TreeNode, TreeNode> parents, Map<TreeNode, Integer> nodeLevels) {
        TreeNode lca = null;
        for (TreeNode node : deepestLeafs) {
            if (current == node) {
                continue;
            }
            TreeNode currentLca = getLcaFor(current, node, parents, nodeLevels);
            if (lca == null) {
                lca = currentLca;
            } else if (nodeLevels.get(currentLca) < nodeLevels.get(lca)) {
                lca = currentLca;
            }
        }
        return lca;
    }

    private TreeNode getLcaFor(TreeNode current, TreeNode node, Map<TreeNode, TreeNode> parents, Map<TreeNode, Integer> nodeLevels) {
        int currentLevel = nodeLevels.get(current);
        int nodeLevel = nodeLevels.get(node);
        if (currentLevel < nodeLevel) {
            return getLcaFor(node, current, parents, nodeLevels);
        }

        while (currentLevel > nodeLevel) {
            current = parents.get(current);
            currentLevel--;
        }

        while (true) {
            if (current == node) {
                return current;
            }
            current = parents.get(current);
            node = parents.get(node);
        }
    }


    private List<TreeNode> getLeafs(List<TreeNode> leafs, int deepestLevel, Map<TreeNode, Integer> nodeLevels) {
        return leafs.stream().filter(l -> nodeLevels.get(l) == deepestLevel).toList();
    }
}

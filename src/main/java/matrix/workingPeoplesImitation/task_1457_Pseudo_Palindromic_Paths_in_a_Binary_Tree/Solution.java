package matrix.workingPeoplesImitation.task_1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree;

import java.util.*;

public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        int countPalindrome = 0;
        List<TreeNode> leafs = new ArrayList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Map<TreeNode, Map<Integer, Integer>> pathToRoot = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
//            Map<Integer, Integer> currentMap = pathToRoot.getOrDefault(current, new HashMap<>());
//            currentMap.merge(current.val, 1, Integer::sum);

            if (current.left == null && current.right == null) leafs.add(current);
            if (current.left != null) {
                parents.put(current.left, current);
                queue.offer(current.left);
                Map<Integer, Integer> currentMap = pathToRoot.getOrDefault(current.left, new HashMap<>());
                currentMap.merge(current.left.val, 1, Integer::sum);
                Map<Integer, Integer> prevMap = pathToRoot.get(current);
                if (prevMap == null) {
                    currentMap.merge(current.val, 1, Integer::sum);
                } else {
                    for (Map.Entry<Integer, Integer> entry : prevMap.entrySet())
                        currentMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
                }
                pathToRoot.put(current.left,currentMap);
            }
            if (current.right != null) {
                parents.put(current.right, current);
                queue.offer(current.right);
                Map<Integer, Integer> currentMap = pathToRoot.getOrDefault(current.right, new HashMap<>());
                currentMap.merge(current.right.val, 1, Integer::sum);
                Map<Integer, Integer> prevMap = pathToRoot.get(current);
                if (prevMap == null) {
                    currentMap.merge(current.val, 1, Integer::sum);
                } else {
                    for (Map.Entry<Integer, Integer> entry : prevMap.entrySet())
                        currentMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
                }
                pathToRoot.put(current.right,currentMap);
            }
//            pathToRoot.put(current,currentMap);
        }
//        for (Map<Integer, Integer> map : pathToRoot.values()) {
//            for (Map.Entry<Integer, Integer> entry : map.entrySet())
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            System.out.println();
//        }
//        System.out.println("————");
        for (TreeNode leaf : leafs) {
            Map<Integer, Integer> currentMap = pathToRoot.get(leaf);
//            Map<Integer, Integer> currentMap = new HashMap<>();
//            TreeNode current = leaf;
//            while (current != null) {
//                currentMap.merge(current.val, 1, Integer::sum);
//                current = parents.get(current);
//            }
//            System.out.println("leaf = " + leaf.val);
            if (possiblePalindrome(currentMap)) countPalindrome++;
        }
        return countPalindrome;
    }

    private boolean possiblePalindrome(Map<Integer, Integer> currentMap) {
//        for (Map.Entry<Integer, Integer> entry : currentMap.entrySet())
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        System.out.println("____");
        if (currentMap.size() == 1) return true;
        boolean hasOne = false;
        for (int val : currentMap.values()) {
            if (val % 2 == 1) {
                if (hasOne) return false;
                else hasOne = true;
            }
        }
        return true;
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
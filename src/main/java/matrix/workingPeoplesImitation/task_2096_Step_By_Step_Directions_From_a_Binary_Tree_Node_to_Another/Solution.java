package matrix.workingPeoplesImitation.task_2096_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.*;

public class Solution {

    // my solution (with hint from GPT)
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        findSubPath(root, startValue, s);
        StringBuilder d = new StringBuilder();
        findSubPath(root, destValue, d);

        if (s == null && d == null) {
            return "";
        } else if (d == null || d.length() == 0) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                result.append('U');
            }
            return result.toString();
        } else if (s == null || s.length() == 0) {
            return d.toString();
        } else if (s.length() > 0 && d.length() > 0) {
            int start = 0;
            while (start < s.length() && start < d.length() && s.charAt(start) == d.charAt(start)) {
                start++;
            }
            StringBuilder result = new StringBuilder();
            for (int j = start; j < s.length(); j++) {
                result.append('U');
            }
            result.append(d.substring(start));
            return result.toString();
        }
        return "";
    }

    private boolean findSubPath(TreeNode root, int value, StringBuilder sb) {
        if (root == null) return false;
        if (root.val == value) return true;
        sb.append("L");
        if (findSubPath(root.left, value, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append("R");
        if (findSubPath(root.right, value, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    // my previous attempts
    public String getDirections1(TreeNode root, int startValue, int destValue) {
        Set<TreeNode> startTrack = new HashSet<>();
        createParentsTrack(root, startValue, startTrack);
        Set<TreeNode> destTrack = new HashSet<>();
        createParentsTrack(root, destValue, destTrack);

        String s = createParentsString(root, startTrack, startValue);
        String d = createParentsString(root, destTrack, destValue);

        System.out.println("startTrack = " + startTrack);
        System.out.println("destTrack = " + destTrack);

        System.out.println("pathS = " + s);
        System.out.println("pathD = " + d);

        if (s == null && d == null) {
            return "";
        } else if (d == null || d.length() == 0) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                result.append('U');
            }
            return result.toString();
        } else if (s == null || s.length() == 0) {
            return d.toString();
        } else if (s.length() > 0 && d.length() > 0) {
            int start = 0;
            while (start < s.length() && start < d.length() && s.charAt(start) == d.charAt(start)) {
                start++;
            }
            StringBuilder result = new StringBuilder();
            for (int j = start; j < s.length(); j++) {
                result.append('U');
            }
            result.append(d.substring(start));
            return result.toString();
        }
        return "";
    }

    private String createParentsString(TreeNode root, Set<TreeNode> track, int value) {
        if (track == null || track.isEmpty()) return "";
        if (root.left != null && track.contains(root.left)) return "L" + createParentsString(root.left, track, value);
        else if (root.right != null && track.contains(root.right)) return "R" + createParentsString(root.right, track, value);
        return "";
    }

    private void createParentsTrack(TreeNode root, int value, Set<TreeNode> track) {
        if (root == null) return;
        track.add(root);
        if (root.val == value) return;
        if (root.left != null & root.right != null) {
            if (root.left.val > value) createParentsTrack(root.left, value, track);
            else if (root.right.val < value) createParentsTrack(root.right, value, track);
//            else
        } else if (root.left != null) {
            createParentsTrack(root.left, value, track);
        } else {
            createParentsTrack(root.right, value, track);
        }
    }

    public String getDirections0(TreeNode root, int startValue, int destValue) {
        boolean findStart = false;
        boolean findDest = false;
        Map<Integer, StringBuilder> childPath = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        childPath.put(root.val, new StringBuilder());
        while ((!findStart || !findDest) && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.val == startValue) findStart = true;
                if (currentNode.val == destValue) findDest = true;
                if (currentNode.left != null) {
                    childPath.put(currentNode.left.val, new StringBuilder(childPath.get(currentNode.val)).append('L'));
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    childPath.put(currentNode.right.val, new StringBuilder(childPath.get(currentNode.val)).append('R'));
                    queue.offer(currentNode.right);
                }
            }
        }

        System.out.println("childPath = " + childPath);

        StringBuilder pathS = childPath.get(startValue);
        StringBuilder pathD = childPath.get(destValue);

        System.out.println("pathS = " + pathS);
        System.out.println("pathD = " + pathD);


        if (pathS == null && pathD == null) {
            return "";
        } else if (pathD == null || pathD.length() == 0) {
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < pathS.length(); j++) {
                result.append('U');
            }
            return result.toString();
        } else if (pathS == null || pathS.length() == 0) {
            return pathD.toString();
        } else if (pathS.length() > 0 && pathD.length() > 0) {
            int start = 0;
            while (start < pathS.length() && start < pathD.length() && pathS.charAt(start) == pathD.charAt(start)) {
                start++;
            }
            StringBuilder result = new StringBuilder();
            for (int j = start; j < pathS.length(); j++) {
                result.append('U');
            }
            result.append(pathD.substring(start));
            return result.toString();
        }
        return "";
    }

    // from leetcode editorial (Approach 1: BFS + DFS)
    public String getDirections3(TreeNode root, int startValue, int destValue) {
        // Map to store parent nodes
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        // Find the start node and populate parent map
        TreeNode startNode = findStartNode(root, startValue);
        populateParentMap(root, parentMap);

        // Perform BFS to find the path
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        Set<TreeNode> visitedNodes = new HashSet<>();
        // Key: next node, Value: <current node, direction>
        Map<TreeNode, Pair<TreeNode, String>> pathTracker = new HashMap<>();
        visitedNodes.add(startNode);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // If destination is reached, return the path
            if (currentNode.val == destValue) {
                return backtrackPath(currentNode, pathTracker);
            }

            // Check and add parent node
            if (parentMap.containsKey(currentNode.val)) {
                TreeNode parentNode = parentMap.get(currentNode.val);
                if (!visitedNodes.contains(parentNode)) {
                    queue.add(parentNode);
                    pathTracker.put(parentNode, new Pair(currentNode, "U"));
                    visitedNodes.add(parentNode);
                }
            }

            // Check and add left child
            if (
                    currentNode.left != null &&
                            !visitedNodes.contains(currentNode.left)
            ) {
                queue.add(currentNode.left);
                pathTracker.put(currentNode.left, new Pair(currentNode, "L"));
                visitedNodes.add(currentNode.left);
            }

            // Check and add right child
            if (
                    currentNode.right != null &&
                            !visitedNodes.contains(currentNode.right)
            ) {
                queue.add(currentNode.right);
                pathTracker.put(currentNode.right, new Pair(currentNode, "R"));
                visitedNodes.add(currentNode.right);
            }
        }

        // This line should never be reached if the tree is valid
        return "";
    }

    private String backtrackPath(
            TreeNode node,
            Map<TreeNode, Pair<TreeNode, String>> pathTracker
    ) {
        StringBuilder path = new StringBuilder();

        // Construct the path
        while (pathTracker.containsKey(node)) {
            // Add the directions in reverse order and move on to the previous node
            path.append(pathTracker.get(node).getValue());
            node = pathTracker.get(node).getKey();
        }

        // Reverse the path
        path.reverse();

        return path.toString();
    }

    private void populateParentMap(
            TreeNode node,
            Map<Integer, TreeNode> parentMap
    ) {
        if (node == null) return;

        // Add children to the map and recurse further
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            populateParentMap(node.left, parentMap);
        }

        if (node.right != null) {
            parentMap.put(node.right.val, node);
            populateParentMap(node.right, parentMap);
        }
    }

    private TreeNode findStartNode(TreeNode node, int startValue) {
        if (node == null) return null;

        if (node.val == startValue) return node;

        TreeNode leftResult = findStartNode(node.left, startValue);

        // If left subtree returns a node, it must be StartNode. Return it
        // Otherwise, return whatever is returned by right subtree.
        if (leftResult != null) return leftResult;
        return findStartNode(node.right, startValue);
    }
    class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // from leetcode editorial (Approach 2: LCA + DFS)
    public String getDirections4(TreeNode root, int startValue, int destValue) {
        // Find the Lowest Common Ancestor (LCA) of start and destination nodes
        TreeNode lowestCommonAncestor = findLowestCommonAncestor(
                root,
                startValue,
                destValue
        );

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Find paths from LCA to start and destination nodes
        findPath(lowestCommonAncestor, startValue, pathToStart);
        findPath(lowestCommonAncestor, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length()));

        // Append the path from LCA to destination
        directions.append(pathToDest);

        return directions.toString();
    }

    private TreeNode findLowestCommonAncestor(
            TreeNode node,
            int value1,
            int value2
    ) {
        if (node == null) return null;

        if (node.val == value1 || node.val == value2) return node;

        TreeNode leftLCA = findLowestCommonAncestor(node.left, value1, value2);
        TreeNode rightLCA = findLowestCommonAncestor(
                node.right,
                value1,
                value2
        );

        if (leftLCA == null) return rightLCA;
        else if (rightLCA == null) return leftLCA;
        else return node; // Both values found, this is the LCA
    }

    private boolean findPath(
            TreeNode node,
            int targetValue,
            StringBuilder path
    ) {
        if (node == null) return false;

        if (node.val == targetValue) return true;

        // Try left subtree
        path.append("L");
        if (findPath(node.left, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath(node.right, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        return false;
    }

    // from leetcode editorial (Approach 3: LCA + DFS (Optimized))
    public String getDirections5(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        // Find paths from root to start and destination nodes
        findPath2(root, startValue, startPath);
        findPath2(root, destValue, destPath);

        StringBuilder directions = new StringBuilder();
        int commonPathLength = 0;

        // Find the length of the common path
        while (
                commonPathLength < startPath.length() &&
                        commonPathLength < destPath.length() &&
                        startPath.charAt(commonPathLength) ==
                                destPath.charAt(commonPathLength)
        ) {
            commonPathLength++;
        }

        // Add "U" for each step to go up from start to common ancestor
        for (int i = 0; i < startPath.length() - commonPathLength; i++) {
            directions.append("U");
        }

        // Add directions from common ancestor to destination
        for (int i = commonPathLength; i < destPath.length(); i++) {
            directions.append(destPath.charAt(i));
        }

        return directions.toString();
    }

    private boolean findPath2(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        // Try left subtree
        path.append("L");
        if (findPath2(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath2(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // Remove last character

        return false;
    }

    // from walkccc.me (Approach 1: LCA + Build paths)
    public String getDirections6(TreeNode root, int startValue, int destValue) {
        // Only this subtree matters.
        dfs(lca(root, startValue, destValue), startValue, destValue, new StringBuilder());
        return "U".repeat(pathToStart.length()) + pathToDest;
    }

    private String pathToStart = "";
    private String pathToDest = "";

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    private void dfs(TreeNode root, int p, int q, StringBuilder path) {
        if (root == null)
            return;
        if (root.val == p)
            pathToStart = path.toString();
        if (root.val == q)
            pathToDest = path.toString();
        dfs(root.left, p, q, path.append('L'));
        path.deleteCharAt(path.length() - 1);
        dfs(root.right, p, q, path.append('R'));
        path.deleteCharAt(path.length() - 1);
    }

    // from walkccc.me (Approach 2: Build paths and remove common prefix)
    public String getDirections7(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        dfs(root, startValue, pathToStart);
        dfs(root, destValue, pathToDest);

        while (pathToStart.length() > 0 && pathToDest.length() > 0 &&
                pathToStart.charAt(pathToStart.length() - 1) ==
                        pathToDest.charAt(pathToDest.length() - 1)) {
            pathToStart.setLength(pathToStart.length() - 1);
            pathToDest.setLength(pathToDest.length() - 1);
        }

        return "U".repeat(pathToStart.length()) + pathToDest.reverse().toString();
    }

    // Builds the string in the reverse order to avoid creating a new copy.
    private boolean dfs(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val)
            return true;
        if (root.left != null && dfs(root.left, val, sb))
            sb.append("L");
        else if (root.right != null && dfs(root.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }

}
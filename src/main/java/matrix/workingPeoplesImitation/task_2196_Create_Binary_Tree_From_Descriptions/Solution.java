package matrix.workingPeoplesImitation.task_2196_Create_Binary_Tree_From_Descriptions;

import java.util.*;

public class Solution {

    // my solution
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> leftChildren = new HashMap<>();
        Map<Integer, TreeNode> rightChildren = new HashMap<>();
        Set<Integer> rootCandidates = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            childSet.add(child);
            rootCandidates.add(parent);
//            if (rootCandidates.contains(parent) || leftChildren.containsKey(parent) || rightChildren.containsKey(parent)) {
//                rootCandidates.remove(parent);
//            } else {
//                rootCandidates.add(parent);
//            }
            TreeNode currentNode = new TreeNode(child);
            if (isLeft == 1) {
                leftChildren.put(parent, currentNode);
            } else {
                rightChildren.put(parent, currentNode);
            }
        }
        TreeNode root = null;
        for (int parentValue : rootCandidates) {
            if (!childSet.contains(parentValue)) {
                root = new TreeNode(parentValue);
                break;
            }
        }
        buildTree(root, leftChildren, rightChildren);
        return root;
    }

    private void buildTree(TreeNode root, Map<Integer, TreeNode> leftChildren, Map<Integer, TreeNode> rightChildren) {
        if (leftChildren.containsKey(root.val)) {
            root.left = leftChildren.get(root.val);
            buildTree(root.left, leftChildren, rightChildren);
        }
        if (rightChildren.containsKey(root.val)) {
            root.right = rightChildren.get(root.val);
            buildTree(root.right, leftChildren, rightChildren);
        }
    }

    // from leetcode editorial (Approach 1: Convert to Graph with Breadth First Search)
    public TreeNode createBinaryTree2(int[][] descriptions) {
        // Sets to track unique children and parents
        Set<Integer> children = new HashSet<>(), parents = new HashSet<>();
        // Map to store parent to children relationships
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();

        // Build graph from parent to child, and add nodes to HashSets
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];
            parents.add(parent);
            parents.add(child);
            children.add(child);
            parentToChildren
                    .computeIfAbsent(parent, l -> new ArrayList<>())
                    .add(new int[] { child, isLeft });
        }

        // Find the root node by checking which node is in parents but not in children
        parents.removeAll(children);
        TreeNode root = new TreeNode(parents.iterator().next());

        // Starting from root, use BFS to construct binary tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            // Iterate over children of current parent
            for (int[] childInfo : parentToChildren.getOrDefault(
                    parent.val,
                    Collections.emptyList()
            )) {
                int childValue = childInfo[0], isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                queue.offer(child);
                // Attach child node to its parent based on isLeft flag
                if (isLeft == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

        return root;
    }

    // from leetcode editorial (Approach 2: Convert to Graph with Depth First Search)
    public TreeNode createBinaryTree3(int[][] descriptions) {
        // Step 1: Organize data
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            // Store child information under parent node
            if (!parentToChildren.containsKey(parent)) {
                parentToChildren.put(parent, new ArrayList<>());
            }
            parentToChildren.get(parent).add(new int[] { child, isLeft });
            allNodes.add(parent);
            allNodes.add(child);
            children.add(child);
        }

        // Step 2: Find the root
        int rootVal = 0;
        for (int node : allNodes) {
            if (!children.contains(node)) {
                rootVal = node;
                break;
            }
        }

        // Step 3 & 4: Build the tree using DFS
        return dfs(parentToChildren, rootVal);
    }

    // DFS function to recursively build binary tree
    private TreeNode dfs(Map<Integer, List<int[]>> parentToChildren, int val) {
        // Create new TreeNode for current value
        TreeNode node = new TreeNode(val);

        // If current node has children, recursively build them
        if (parentToChildren.containsKey(val)) {
            for (int[] childInfo : parentToChildren.get(val)) {
                int child = childInfo[0];
                int isLeft = childInfo[1];

                // Attach child node based on isLeft flag
                if (isLeft == 1) {
                    node.left = dfs(parentToChildren, child);
                } else {
                    node.right = dfs(parentToChildren, child);
                }
            }
        }

        return node;
    }

    // from leetcode editorial (Approach 3: Constructing Tree From Directly Map and TreeNode Object)
    public TreeNode createBinaryTree4(int[][] descriptions) {
        // Maps values to TreeNode pointers
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        // Stores values which are children in the descriptions
        Set<Integer> children = new HashSet<>();

        // Iterate through descriptions to create nodes and set up tree structure
        for (int[] description : descriptions) {
            // Extract parent value, child value, and whether it is a
            // left child (1) or right child (0)
            int parentValue = description[0];
            int childValue = description[1];
            boolean isLeft = description[2] == 1;

            // Create parent and child nodes if not already created
            if (!nodeMap.containsKey(parentValue)) {
                nodeMap.put(parentValue, new TreeNode(parentValue));
            }
            if (!nodeMap.containsKey(childValue)) {
                nodeMap.put(childValue, new TreeNode(childValue));
            }

            // Attach child node to parent's left or right branch
            if (isLeft) {
                nodeMap.get(parentValue).left = nodeMap.get(childValue);
            } else {
                nodeMap.get(parentValue).right = nodeMap.get(childValue);
            }

            // Mark child as a child in the set
            children.add(childValue);
        }

        // Find and return the root node
        for (TreeNode node : nodeMap.values()) {
            if (!children.contains(node.val)) {
                return node; // Root node found
            }
        }

        return null; // Should not occur according to problem statement
    }

    // from walkccc.me
    public TreeNode createBinaryTree5(int[][] descriptions) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();

        for (int[] d : descriptions) {
            final int p = d[0];
            final int c = d[1];
            final int isLeft = d[2];
            TreeNode parent = valToNode.getOrDefault(p, new TreeNode(p));
            TreeNode child = valToNode.getOrDefault(c, new TreeNode(c));
            valToNode.put(p, parent);
            valToNode.put(c, child);
            childToParent.put(child, parent);
            if (isLeft == 1)
                parent.left = child;
            else
                parent.right = child;
        }

        // Pick a random node and traverse upwardly.
        TreeNode root = childToParent.keySet().iterator().next();
        while (childToParent.containsKey(root))
            root = childToParent.get(root);
        return root;
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

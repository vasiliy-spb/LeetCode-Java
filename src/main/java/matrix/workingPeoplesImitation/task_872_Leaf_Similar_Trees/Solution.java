package matrix.workingPeoplesImitation.task_872_Leaf_Similar_Trees;

import java.util.*;

public class Solution {

    // my solution
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        while (!stack1.empty()) {
            TreeNode current = stack1.pop();
            if (current.left == null && current.right == null) values1.add(current.val);
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }

        stack2.push(root2);
        while (!stack2.empty()) {
            TreeNode current = stack2.pop();
            if (current.left == null && current.right == null) values2.add(current.val);
            if (current.left != null) stack2.push(current.left);
            if (current.right != null) stack2.push(current.right);
        }
        return values1.equals(values2);
    }

    // from leetcode editorial
    //
    // Let's find the leaf value sequence for both given trees. Afterwards, we can compare them to see if they are equal or not.
    // To find the leaf value sequence of a tree, we use a depth first search.
    // Our dfs function writes the node's value if it is a leaf, and then recursively explores each child.
    // This is guaranteed to visit each leaf in left-to-right order, as left-children are fully explored before right-children.
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
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
}

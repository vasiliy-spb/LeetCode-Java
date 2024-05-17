package matrix.workingPeoplesImitation.task_2331_Evaluate_Boolean_Binary_Tree;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    // my solution
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1;
        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) : evaluateTree(root.left) && evaluateTree(root.right);
    }

    // my solution 2
    public boolean evaluateTree1(TreeNode root) {
        return root.left == null ? root.val == 1 :
                root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) :
                        evaluateTree(root.left) && evaluateTree(root.right);

    }

    // from editorial (Approach 1: Recursion (Depth First Search))
    public boolean evaluateTree2(TreeNode root) {
        // Handles the case for leaf nodes.
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }

        // Store the evaluations for the left subtree and right subtree.
        boolean evaluateLeftSubtree = evaluateTree2(root.left);
        boolean evaluateRightSubtree = evaluateTree2(root.right);
        boolean evaluateRoot;
        if (root.val == 2) {
            evaluateRoot = evaluateLeftSubtree | evaluateRightSubtree;
        } else {
            evaluateRoot = evaluateLeftSubtree & evaluateRightSubtree;
        }

        return evaluateRoot;
    }

    // from editorial (Approach 2: Iterative approach (Depth First Search))
    public boolean evaluateTree3(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        HashMap<TreeNode, Boolean> evaluated = new HashMap<>();

        while (!st.isEmpty()) {
            TreeNode topNode = st.peek();

            // If the node is a leaf node, store its value in the evaluated hashmap
            // and continue
            if (topNode.left == null && topNode.right == null) {
                st.pop();
                evaluated.put(topNode, topNode.val == 1);
                continue;
            }

            // If both the children have already been evaluated, use their
            // values to evaluate the current node.
            if (evaluated.containsKey(topNode.left) &&
                    evaluated.containsKey(topNode.right)) {
                st.pop();
                if (topNode.val == 2) {
                    evaluated.put(topNode,
                            evaluated.get(topNode.left) || evaluated.get(topNode.right));
                } else {
                    evaluated.put(topNode,
                            evaluated.get(topNode.left) && evaluated.get(topNode.right));
                }
            } else {
                // If both the children are not leaf nodes, push the current
                // node along with its left and right child back into the stack.
                st.push(topNode.right);
                st.push(topNode.left);
            }
        }

        return evaluated.get(root);
    }

    // from walkccc.me
    public boolean evaluateTree4(TreeNode root) {
        if (root.val < 2)
            return root.val == 1;
        if (root.val == 2) // OR
            return evaluateTree(root.left) || evaluateTree(root.right);
        // AND
        return evaluateTree(root.left) && evaluateTree(root.right);
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
}

package matrix.workingPeoplesImitation.task_236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.*;

public class Solution {

    // my solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean foundLeft = false;
        boolean foundRight = false;
        TreeNode current = root;
        while (!foundLeft || !foundRight) {
            if (current.val == p.val || current.val == q.val) return current;
            if (current.left != null) {
                foundLeft = findBothNode(current.left, p, q);
            } else {
                foundLeft = false;
            }
            if (current.right != null) {
                foundRight = findBothNode(current.right, p, q);
            } else {
                foundRight = false;
            }
//            System.out.printf("current.val = %d, foundLeft = %s, foundRight = %s\n", current.val, foundLeft, foundRight);
            if (foundLeft && foundRight) return current;
            if (!foundLeft && current.right != null) current = current.right;
            if (!foundRight && current.left != null) current = current.left;
        }
        return current;
    }

    public boolean findBothNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean foundP = false, foundQ = false;
        while (!queue.isEmpty() && (!foundP && !foundQ)) {
            TreeNode current = queue.poll();
            if (current.val == p.val) foundP = true;
            if (current.val == q.val) foundQ = true;
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        return foundP || foundQ;
    }

    // from walkccc.me (Approach 1: Recursive)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    // from walkccc.me (Approach 2: Iterative)
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> q_ = new ArrayDeque<>(Arrays.asList(root));
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Set<TreeNode> ancestors = new HashSet<>(); // p's ancestors

        // Iterate until we find both p and q.
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            root = q_.poll();
            if (root.left != null) {
                parent.put(root.left, root);
                q_.offer(root.left);
            }
            if (root.right != null) {
                parent.put(root.right, root);
                q_.offer(root.right);
            }
        }

        // Insert all the p's ancestors.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p); // `p` becomes null in the end.
        }

        // Go up from q until we meet any of p's ancestors.
        while (!ancestors.contains(q))
            q = parent.get(q);

        return q;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
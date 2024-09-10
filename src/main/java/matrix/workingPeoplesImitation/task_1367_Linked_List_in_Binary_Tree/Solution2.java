package matrix.workingPeoplesImitation.task_1367_Linked_List_in_Binary_Tree;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;
import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode editorial (Approach 1: DFS)
public class Solution2 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return checkPath(root, head);
    }

    private boolean checkPath(TreeNode node, ListNode head) {
        if (node == null) return false;
        if (dfs(node, head)) return true; // If a matching path is found
        // Recursively check left and right subtrees
        return checkPath(node.left, head) || checkPath(node.right, head);
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) return true; // All nodes in the list matched
        if (node == null) return false; // Reached end of tree without matching all nodes
        if (node.val != head.val) return false; // Value mismatch
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}

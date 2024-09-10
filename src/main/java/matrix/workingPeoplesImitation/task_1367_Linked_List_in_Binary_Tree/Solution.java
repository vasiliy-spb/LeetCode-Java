package matrix.workingPeoplesImitation.task_1367_Linked_List_in_Binary_Tree;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;
import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

// my solution
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == head.val) {
                if (containsPath(head, current)) {
                    return true;
                }
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }
    private boolean containsPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        return containsPath(head.next, root.left) || containsPath(head.next, root.right);
    }
}

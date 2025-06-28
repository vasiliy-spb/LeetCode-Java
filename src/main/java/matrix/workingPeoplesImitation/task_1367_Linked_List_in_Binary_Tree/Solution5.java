package matrix.workingPeoplesImitation.task_1367_Linked_List_in_Binary_Tree;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;
import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me
public class Solution5 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        return isContinuousSubPath(head, root) || isSubPath(head, root.left) ||
                isSubPath(head, root.right);
    }

    private boolean isContinuousSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return head.val == root.val &&
                (isContinuousSubPath(head.next, root.left) || isContinuousSubPath(head.next, root.right));
    }
}

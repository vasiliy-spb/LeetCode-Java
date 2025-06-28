package matrix.workingPeoplesImitation.task_1721_Swapping_Nodes_in_a_Linked_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (3)
public class Solution5 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        while(k > 1) {
            temp = temp.next;
            k--;
        }
        ListNode left = temp, right = head;
        while(temp.next != null) {
            temp = temp.next;
            right = right.next;
        }
        int value = left.val;
        left.val = right.val;
        right.val = value;
        return head;
    }
}

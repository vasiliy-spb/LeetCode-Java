package matrix.workingPeoplesImitation.task_1721_Swapping_Nodes_in_a_Linked_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// my solution
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        current = head;
        int i = 0;
        ListNode temp = null;
        while (current != null) {
            i++;
            if (i == k || i == length - k + 1) {
                if (temp == null) {
                    temp = current;
                } else {
                    temp.val += current.val;
                    current.val = temp.val - current.val;
                    temp.val -= current.val;
                }

            }
            current = current.next;
        }
        return head;
    }
}

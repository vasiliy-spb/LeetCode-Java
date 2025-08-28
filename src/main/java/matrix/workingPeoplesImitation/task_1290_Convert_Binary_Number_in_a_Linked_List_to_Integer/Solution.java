package matrix.workingPeoplesImitation.task_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// my solution
public class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}

package matrix.workingPeoplesImitation.task_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (1)
public class Solution3 {
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
    }
}

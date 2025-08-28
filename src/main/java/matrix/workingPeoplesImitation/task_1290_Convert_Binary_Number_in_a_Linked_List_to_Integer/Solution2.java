package matrix.workingPeoplesImitation.task_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from walkccc.me
public class Solution2 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;

        for (; head != null; head = head.next)
            ans = ans * 2 + head.val;

        return ans;
    }
}

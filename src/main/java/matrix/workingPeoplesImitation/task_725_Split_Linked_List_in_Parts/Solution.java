package matrix.workingPeoplesImitation.task_725_Split_Linked_List_in_Parts;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// my solution
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        int n = size / k;
        int countAdd = size % k;
        ListNode[] ans = new ListNode[k];
        for (int i = 0; i < k; i++) {
            if (head == null) {
                break;
            }
            ans[i] = head;
            ListNode subList = ans[i];
            head = head.next;
            for (int j = i < countAdd ? 0 : 1; j < n && head != null; j++) {
                subList = subList.next;
                head = head.next;
            }
            if (subList != null) {
                subList.next = null;
            }
        }
        return ans;
    }
}

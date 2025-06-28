package matrix.workingPeoplesImitation.task_445_Add_Two_Numbers_II;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// my solution
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverseLinkedList(l1);
        ListNode reverse2 = reverseLinkedList(l2);
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        boolean add = false;
        int value = 0;
        while (reverse1 != null && reverse2 != null) {
            value = reverse1.val + reverse2.val + (add ? 1 : 0);
            dummy.next = new ListNode(value % 10);
            dummy = dummy.next;
            add = value >= 10;
            reverse1 = reverse1.next;
            reverse2 = reverse2.next;
        }
        while (reverse1 != null) {
            value = reverse1.val + (add ? 1 : 0);
            dummy.next = new ListNode(value % 10);
            dummy = dummy.next;
            add = value >= 10;
            reverse1 = reverse1.next;
        }
        while (reverse2 != null) {
            value = reverse2.val + (add ? 1 : 0);
            dummy.next = new ListNode(value % 10);
            dummy = dummy.next;
            add = value >= 10;
            reverse2 = reverse2.next;
        }
        if (add) {
            dummy.next = new ListNode(1);
        }
        return reverseLinkedList(ans.next);
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

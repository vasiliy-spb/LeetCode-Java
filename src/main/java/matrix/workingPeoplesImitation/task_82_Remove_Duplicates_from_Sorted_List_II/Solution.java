package matrix.workingPeoplesImitation.task_82_Remove_Duplicates_from_Sorted_List_II;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = null;
        ListNode tail = null;
        ListNode current = head;
        ListNode prev = null;
        int count = 0;
        while (current != null) {
            if (prev != null && current.val == prev.val) count++;
            else {
                if (prev != null) {
                    if (count == 1) {
                        if (tail == null) {
                            tail = prev;
                            newHead = tail;
                        } else {
                            tail.next = prev;
                            tail = tail.next;
                        }
                    }
                }
                count = 1;
            }
            prev = current;
            current = current.next;
        }
        if (tail != null) tail.next = null;
        if (count == 1 && tail != null && tail.val != prev.val) {
            prev.next = null;
            tail.next = prev;
        }
        if (newHead == null) return prev == null && count < 2 ? null : count < 2 ? prev : null;
        return newHead;
    }

    // from walkccc.me
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            if (prev.next == head)
                prev = prev.next;
            else
                prev.next = head.next;
            head = head.next;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

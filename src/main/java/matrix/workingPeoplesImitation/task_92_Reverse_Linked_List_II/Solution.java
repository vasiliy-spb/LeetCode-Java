package matrix.workingPeoplesImitation.task_92_Reverse_Linked_List_II;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        int position = 1;
        while (current != null && position != left) {
            prev = current;
            current = current.next;
            position++;
        }
        if (prev != null) prev.next = reverseTail(current, right, position);
        else return reverseTail(current, right, position);
        return head;
    }

    public ListNode reverseTail(ListNode head, int right, int position) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null && position <= right) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            position++;
        }
        head.next = current;
        return prev;
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
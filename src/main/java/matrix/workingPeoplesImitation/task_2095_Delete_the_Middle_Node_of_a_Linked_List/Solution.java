package matrix.workingPeoplesImitation.task_2095_Delete_the_Middle_Node_of_a_Linked_List;

public class Solution {

    // my solution
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode middle = head;
        ListNode tail = head;
        ListNode preMiddle = null;
        while (middle != null && tail != null && tail.next != null) {
            preMiddle = middle;
            middle = middle.next;
            tail = tail.next.next;
        }
        preMiddle.next = middle.next;
        return head;
    }

    // from walkccc.me
    public ListNode deleteMiddle2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node.
        slow.next = slow.next.next;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val).append(" — ");
            current = current.next;
        }
        return result.toString();
    }
}
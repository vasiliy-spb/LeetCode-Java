package matrix.workingPeoplesImitation.task_24_Swap_Nodes_in_Pairs;

public class Solution {

    // my solution
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        temp1.next = swapPairs(head.next.next);
        temp2.next = head;
        head = temp2;
        return head;
    }

    // from walkccc.me
    public ListNode swapPairs2(ListNode head) {
        final int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        for (int i = 0; i < length / 2; ++i) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            ++length;
        return length;
    }

    // from leetcode solutions
    public ListNode swapPairs3(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs3(head.next.next);
        n.next = head;
        return n;
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
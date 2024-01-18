package matrix.workingPeoplesImitation.task_328_Odd_Even_Linked_List;

public class Solution {

    // my solution
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode odd = new ListNode(head.val);
        ListNode first = odd;
        ListNode even = new ListNode(head.next.val);
        ListNode second = even;
        ListNode current = head.next.next;
        for (int i = 1; i < 1e4 + 2; i++) {
            if (current == null) break;
            if (i % 2 != 0) {
                odd.next = new ListNode(current.val);
                odd = odd.next;
            } else {
                even.next = new ListNode(current.val);
                even = even.next;
            }
            current = current.next;
        }
        odd.next = second;
        return first;
    }

    // from leetcode solutions
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    // from leetcode solutions
    public ListNode oddEvenList3(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        final ListNode eHead = head.next;
        ListNode even = eHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = eHead;
        return head;
    }

    // from walkccc.me
    public ListNode oddEvenList4(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead;
        ListNode even = evenHead;

        for (boolean isOdd = true; head != null; head = head.next, isOdd = !isOdd)
            if (isOdd) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }

        odd.next = evenHead.next;
        even.next = null;
        return oddHead.next;
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
//        return String.valueOf(this.val);
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val).append(" — ");
            current = current.next;
        }
        return result.toString();
    }
}

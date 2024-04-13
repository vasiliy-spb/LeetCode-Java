package matrix.workingPeoplesImitation.task_86_Partition_List;

public class Solution {

    // my solution (O(1) memory)
    public ListNode partition(ListNode head, int x) {
        ListNode firstPart = null;
        ListNode firstPartHead = null;
        ListNode secondPart = null;
        ListNode secondPartHead = null;
        while (head != null) {
            if (head.val < x) {
                if (firstPart == null) {
                    firstPart = head;
                    firstPartHead = firstPart;
                } else {
                    firstPart.next = head;
                    firstPart = firstPart.next;
                }
            } else {
                if (secondPart == null) {
                    secondPart = head;
                    secondPartHead = secondPart;
                } else {
                    secondPart.next = head;
                    secondPart = secondPart.next;
                }
            }
            head = head.next;
        }
        if (secondPart != null) secondPart.next = null;
        if (firstPartHead == null) return secondPartHead;
        firstPart.next = secondPartHead;
        return firstPartHead;
    }

    // my solution (O(n) memory)
    public ListNode partition1(ListNode head, int x) {
        ListNode firstPart = null;
        ListNode firstPartHead = null;
        ListNode secondPart = null;
        ListNode secondPartHead = null;
        while (head != null) {
            if (head.val < x) {
                if (firstPart == null) {
                    firstPart = new ListNode(head.val);
                    firstPartHead = firstPart;
                } else {
                    firstPart.next = new ListNode(head.val);
                    firstPart = firstPart.next;
                }
            } else {
                if (secondPart == null) {
                    secondPart = new ListNode(head.val);
                    secondPartHead = secondPart;
                } else {
                    secondPart.next = new ListNode(head.val);
                    secondPart = secondPart.next;
                }
            }
            head = head.next;
        }
        if (firstPartHead == null) return secondPartHead;
        firstPart.next = secondPartHead;
        return firstPartHead;
    }

    // from walkccc.me
    public ListNode partition2(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        for (; head != null; head = head.next)
            if (head.val < x) {
                before.next = head;
                before = head;
            } else {
                after.next = head;
                after = head;
            }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
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
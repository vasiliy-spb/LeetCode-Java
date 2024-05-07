package matrix.workingPeoplesImitation.task_2816_Double_a_Number_Represented_as_a_Linked_List;

public class Solution {

    // my solution
    public ListNode doubleIt(ListNode head) {
        head = reverseLinkedList(head);
        int add = 0;
        ListNode current = head;
        while (current.next != null) {
            int curr = current.val * 2 + add;
            current.val = curr % 10;
            add = curr / 10;
            current = current.next;
        }
        int curr = current.val * 2 + add;
        current.val = curr % 10;
        add = curr / 10;
        if (add > 0) current.next = new ListNode(add);
        return reverseLinkedList(head);
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // from walkccc.me (Approach 1: Recursive)
    public ListNode doubleIt2(ListNode head) {
        if (getCarry(head) == 1)
            return new ListNode(1, head);
        return head;
    }

    private int getCarry(ListNode node) {
        int val = node.val * 2;
        if (node.next != null)
            val += getCarry(node.next);
        node.val = val % 10;
        return val / 10;
    }

    // from walkccc.me (Approach 2: Iterative)
    public ListNode doubleIt3(ListNode head) {
        if (head.val >= 5)
            head = new ListNode(0, head);

        for (ListNode curr = head; curr != null; curr = curr.next) {
            curr.val *= 2;
            curr.val %= 10;
            if (curr.next != null && curr.next.val >= 5)
                ++curr.val;
        }

        return head;
    }

    private static class ListNode {
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
}


/*

head =
[1]
Expected
[2]


head =
[5]
Expected
[1,0]


 */
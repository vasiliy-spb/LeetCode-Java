package matrix.workingPeoplesImitation.task_2807_Insert_Greatest_Common_Divisors_in_Linked_List;

public class Solution {

    // my solution
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            ListNode temp = current.next;
            int gcd = calculateGCD(current.val, temp.val);
            current.next = new ListNode(gcd);
            current = current.next;
            current.next = temp;
            current = current.next;
        }
        return head;
    }

    private int calculateGCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    // from walkccc.me
    public ListNode insertGreatestCommonDivisors2(ListNode head) {
        for (ListNode curr = head; curr.next != null;) {
            ListNode inserted = new ListNode(gcd(curr.val, curr.next.val), curr.next);
            curr.next = inserted;
            curr = inserted.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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

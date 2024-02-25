package matrix.workingPeoplesImitation.task_2_Add_Two_Numbers;

import java.math.BigInteger;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder num1 = new StringBuilder();
        while (l1 != null) {
            num1.append(l1.val);
            l1 = l1.next;
        }
        StringBuilder num2 = new StringBuilder();
        while (l2 != null) {
            num2.append(l2.val);
            l2 = l2.next;
        }
        BigInteger bigInteger1 = new BigInteger(num1.reverse().toString());
        BigInteger bigInteger2 = new BigInteger(num2.reverse().toString());
        StringBuilder sum = new StringBuilder(bigInteger1.add(bigInteger2).toString());
        ListNode result;
        ListNode current = new ListNode();
        for (int i = 0; i < sum.length(); i++) {
            current.val = sum.charAt(i) - '0';
            if (i < sum.length() - 1) {
                result = new ListNode();
                result.next = current;
                current = result;
            }
        }
        return current;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        long a = 0;
        long position = 1;
        while (l1 != null) {
            a += l1.val * position;
            position *= 10;
            l1 = l1.next;
        }
        long b = 0;
        position = 1;
        while (l2 != null) {
            b += l2.val * position;
            position *= 10;
            l2 = l2.next;
        }
        a += b;
        ListNode result = new ListNode((int) (a % 10));
        a /= 10;
        ListNode current = result;
        while (a > 0) {
            current.next = new ListNode((int) (a % 10));
            current = current.next;
            a /= 10;
        }
        current.next = null;
        return result;
    }

    // from leetcode editorial
    // Add Two Numbers (Java improved)
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
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
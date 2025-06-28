package matrix.workingPeoplesImitation.task_206_Reverse_Linked_List;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    // my solution
    public ListNode reverseList0(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            stack.push(head);
            head = next;
        }
        ListNode newHead = stack.pop();
        ListNode current = newHead;
        while (!stack.empty()) {
            current.next = stack.pop();
            current = current.next;
        }
        return newHead;
    }

    // from walkccc.me (Approach 1: Recursive)
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // from walkccc.me (Approach 2: Iterative)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
    }
}
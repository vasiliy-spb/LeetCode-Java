package matrix.workingPeoplesImitation.task_234_Palindrome_Linked_List;

import java.util.Stack;

public class Solution {

    // my solution
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head;
        ListNode tail = head;
        while (middle != null && tail != null && tail.next != null) {
            middle = middle.next;
            tail = tail.next.next;
        }

        ListNode prev = null;
        while (middle != null) {
            ListNode next = middle.next;
            middle.next = prev;
            prev = middle;
            middle = next;
        }
        while (prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    // my solution
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode tail = head;
        while (tail != null) {
            stack.push(tail.val);
            tail = tail.next;
        }
        int length = stack.size() % 2 == 0 ? stack.size() / 2 : stack.size() / 2 + 1;
        while (length-- > 0) {
            if (stack.pop() != head.val) return false;
            head = head.next;
        }
        return true;
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
package matrix.workingPeoplesImitation.task_876_Middle_of_the_Linked_List;

public class Solution {

    // my solution
    public ListNode middleNode(ListNode head) {
        ListNode firstHalf = head;
        ListNode secondHalf = head;
        while (firstHalf != null && secondHalf != null && secondHalf.next != null) {
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next.next;
        }
        if (firstHalf == null) return secondHalf;
        return firstHalf;
    }

    // from walkccc.me | and from leetcode solution ()
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // from leetcode solutions (https://leetcode.com/problems/middle-of-the-linked-list/solutions/1651627/c-java-easy-to-solve-different-variations-with-detailed-explanations/)
    //
    //    Two Pointer Algorithm or Tortoise and Hare Algorithm :
    //    Initialize the two pointers slow and fast at the head of linked list .
    //    Now every time, slow moves 1 step at a time while fast is moves 2 steps at a time. When fast pointer arrives at the end, slow pointer will arrive right in the middle of our linked list.
    //    Now just return the value of slow pointer .
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head, fast = head;
        // slow moving 1 step at a time while fast is moving 2 steps at a time #O(N/2)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
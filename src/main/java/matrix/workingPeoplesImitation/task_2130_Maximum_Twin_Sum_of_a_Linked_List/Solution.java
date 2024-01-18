package matrix.workingPeoplesImitation.task_2130_Maximum_Twin_Sum_of_a_Linked_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    // my solution
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int maxSum = 0;
        for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
            maxSum = Math.max(list.get(i) + list.get(j), maxSum);
        }
        return maxSum;
    }

    // from walkccc.me
    public int pairSum2 (ListNode head) {
        int ans = 0;
        ListNode slow = head;
        ListNode fast = head;

        // `slow` points to the start of the second half.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // `tail` points to the end of the reversed second half.
        ListNode tail = reverseList(slow);

        while (tail != null) {
            ans = Math.max(ans, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }

        return ans;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // from leetcode solutions
    public int pairSum3(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = head;
        while(dummy != null){
            stack.push(dummy);
            dummy = dummy.next;
        }
        int max = 0;
        while(stack.size() > stack.size()/2){
            max = Math.max(max, (head.val + stack.pop().val));
            head = head.next;
        }
        return max;
    }

    // from leetcode solutions
    public int pairSum4(ListNode head) {

        //find the middle
        ListNode middle = findMiddle(head);

        //reverse second half
        ListNode second = reverse(middle);

        //find pair sum max
        int max = 0;
        while (head != null && second != null) {

            max = Math.max(head.val + second.val, max);
            head = head.next;
            second = second.next;
        }
        return max;
    }

    public ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
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
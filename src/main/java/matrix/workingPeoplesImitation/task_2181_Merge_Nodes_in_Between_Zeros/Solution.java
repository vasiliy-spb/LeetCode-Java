package matrix.workingPeoplesImitation.task_2181_Merge_Nodes_in_Between_Zeros;

public class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int sum = 0;
        while (current != null) {
            if (current.val == 0) {
                dummy.next = new ListNode(sum);
                sum = 0;
                dummy = dummy.next;
            } else {
                sum += current.val;
            }
            current = current.next;
        }
        return result.next;
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

    // from walkccc.me (Approach 1: Recursive)
    public ListNode mergeNodes2(ListNode head) {
        if (head == null)
            return null;
        if (head.next.val == 0) {
            ListNode node = new ListNode(head.val);
            node.next = mergeNodes2(head.next.next);
            return node;
        }

        ListNode next = mergeNodes2(head.next);
        next.val += head.val;
        return next;
    }

    // from walkccc.me (Approach 2: Iterative)
    public ListNode mergeNodes3(ListNode head) {
        ListNode curr = head.next;

        while (curr != null) {
            ListNode running = curr;
            int sum = 0;
            while (running.val > 0) {
                sum += running.val;
                running = running.next;
            }
            curr.val = sum;
            curr.next = running.next;
            curr = running.next;
        }

        return head.next;
    }

    // from leetcode editorial (Approach 1: Two-Pointer (One-Pass))
    public ListNode mergeNodes4(ListNode head) {
        // Initialize a sentinel/dummy node with the first non-zero value.
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            // Find the sum of all nodes until you encounter a 0.
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            // Assign the sum to the current node's value.
            modify.val = sum;
            // Move nextSum to the first non-zero value of the next block.
            nextSum = nextSum.next;
            // Move modify also to this node.
            modify.next = nextSum;
            modify = modify.next;
        }
        return head.next;
    }

    // from leetcode editorial (Approach 2: Recursion)
    public ListNode mergeNodes5(ListNode head) {
        // Start with the first non-zero value.
        head = head.next;
        if (head == null) {
            return head;
        }

        // Initialize a dummy head node.
        ListNode temp = head;
        int sum = 0;
        while (temp.val != 0) {
            sum += temp.val;
            temp = temp.next;
        }

        // Store the sum in head's value.
        head.val = sum;
        // Store head's next node as the recursive result for temp node.
        head.next = mergeNodes5(temp);
        return head;
    }

}

package matrix.workingPeoplesImitation.task_25_Reverse_Nodes_in_k_Group;

public class Solution {

    // my solution
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 1;
        ListNode current = head;
        while (current != null && length < k) {
            length++;
            current = current.next;
        }
        if (length < k || current == null) return head;
        ListNode prev = null;
        while (length > 0) {
            ListNode next = head.next;
            if (length == k) head.next = reverseKGroup(current.next,k);
            else head.next = prev;
            prev = head;
            head = next;
            length--;
        }
        return prev;
    }

    // my solution (with comments from GPT)
    public ListNode reverseKGroup0(ListNode head, int k) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) return head;

        // Calculate the length of the current group (should be less than or equal to k)
        int length = 1;
        ListNode current = head;
        while (current != null && length < k) {
            length++;
            current = current.next;
        }

        // If the length is less than k or if we reached the end of the list, return the original list
        if (length < k || current == null) return head;

        // Initialize a variable to keep track of the previous node (will be used for connecting reversed groups)
        ListNode prev = null;

        // Reverse the current group of k nodes
        while (length > 0) {
            // Save the reference to the next node in the original list
            ListNode next = head.next;

            // If this is the last node in the group, recursively reverse the next group (if any)
            if (length == k) head.next = reverseKGroup0(current.next, k);
            else head.next = prev;  // Otherwise, connect the current node to the reversed part

            // Update the previous node to the current node
            prev = head;

            // Move to the next node in the original list
            head = next;

            // Decrement the length to process the next node in the group
            length--;
        }

        // Return the head of the reversed group
        return prev;
    }


    // from walkccc.me (Approach 1: Recursive)
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null)
            return null;

        ListNode tail = head;

        for (int i = 0; i < k; ++i) {
            // There are less than k nodes in the list, do nothing.
            if (tail == null)
                return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup2(tail, k);
        return newHead;
    }

    // Reverses [head, tail).
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // from walkccc.me (Approach 2: Iterative)
    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        final int length = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        for (int i = 0; i < length / k; ++i) {
            for (int j = 0; j < k - 1; ++j) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next)
            ++length;
        return length;
    }

    // from leetcode solutions
    public ListNode reverseKGroup4(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup4(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
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
            result.append(current.val);
            current = current.next;
            if (current != null) result.append(" — ");
        }
        return result.toString();
    }

}
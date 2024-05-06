package matrix.workingPeoplesImitation.task_2487_Remove_Nodes_From_Linked_List;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
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

    // my solution
    public ListNode removeNodes(ListNode head) {
        ListNode current = head;
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        while (current != null) {
            while (!stack.isEmpty() && stack.peekLast().val < current.val)
                stack.pollLast();
            if (!stack.isEmpty()) stack.peekLast().next = current;
            stack.offer(current);
            current = current.next;
        }
        return stack.getFirst();
    }

    // from editorial (Approach 1: Stack)
    public ListNode removeNodes2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Add nodes to the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = stack.pop();
        int maximum = current.val;
        ListNode resultList = new ListNode(maximum);

        // Remove nodes from the stack and add to result
        while (!stack.isEmpty()) {
            current = stack.pop();
            // Current should not be added to the result
            if (current.val < maximum) {
                continue;
            }
            // Add new node with current's value to front of the result
            else {
                ListNode newNode = new ListNode(current.val);
                newNode.next = resultList;
                resultList = newNode;
                maximum = current.val;
            }
        }

        return resultList;
    }

    // from editorial (Approach 2: Recursion)
    public ListNode removeNodes3(ListNode head) {
        // Base case, reached end of the list
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive call
        ListNode nextNode = removeNodes3(head.next);

        // If the next node has greater value than head, delete the head
        // Return next node, which removes the current head and makes next the new head
        if (head.val < nextNode.val) {
            return nextNode;
        }

        // Keep the head
        head.next = nextNode;
        return head;
    }

    // from editorial (Approach 3: Reverse Twice)
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextTemp = null;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public ListNode removeNodes4(ListNode head) {
        // Reverse the original linked list
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        // Traverse the list deleting nodes
        while (current != null) {
            maximum = Math.max(maximum, current.val);

            // Delete nodes that are smaller than maximum
            if (current.val < maximum) {
                // Delete current by skipping
                prev.next = current.next;
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;
            }

            // Current does not need to be deleted
            else {
                prev = current;
                current = current.next;
            }
        }

        // Reverse and return the modified linked list
        return reverseList(head);
    }

    // from walkccc.me
    public ListNode removeNodes5(ListNode head) {
        if (head == null)
            return null;
        head.next = removeNodes5(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }

}

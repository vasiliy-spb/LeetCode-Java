package matrix.workingPeoplesImitation.task_237_Delete_Node_in_a_Linked_List;

public class Solution {

    // my solution
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while (next != null) {
            node.val = next.val;
            node.next = next.next;
            node = node.next;
            next = next.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // from editorial
    public void deleteNode2(ListNode node) {
        // Overwrite data of next node on current node.
        node.val = node.next.val;
        // Make current node point to next of next node.
        node.next = node.next.next;
    }

}

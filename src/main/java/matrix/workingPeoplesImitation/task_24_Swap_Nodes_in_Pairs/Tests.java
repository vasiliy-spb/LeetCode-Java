package matrix.workingPeoplesImitation.task_24_Swap_Nodes_in_Pairs;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode expected = new ListNode(2);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(4);
        expected.next.next.next = new ListNode(3);

        assertTrue(areLinkedListsEquals(expected, testingClass.swapPairs(head)));
    }

    private boolean areLinkedListsEquals(ListNode expected, ListNode head) {
        while (expected != null && head != null) {
            System.out.println("expected.val = " + expected.val + ", current.val = " + head.val);
            if (expected.val != head.val) return false;
            expected = expected.next;
            head = head.next;
        }
        System.out.println();
        return head == null && expected == null;
    }
}

package matrix.workingPeoplesImitation.task_25_Reverse_Nodes_in_k_Group;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] input = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = createLinkedListFromArray(input, 0);
        int[] output = {2, 1, 4, 3, 5};
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.reverseKGroup(head, k)));
    }

    @Test
    public void checkTestcase2() {
        int[] input = {1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = createLinkedListFromArray(input, 0);
        int[] output = {3, 2, 1, 4, 5};
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.reverseKGroup(head, k)));
    }

    private ListNode createLinkedListFromArray(int[] array, int index) {
        if (index >= array.length) return null;
        ListNode head = new ListNode(array[index++]);
        head.next = createLinkedListFromArray(array, index);
        return head;
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

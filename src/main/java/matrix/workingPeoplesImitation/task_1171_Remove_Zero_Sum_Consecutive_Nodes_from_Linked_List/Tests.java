package matrix.workingPeoplesImitation.task_1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] input = {1, 2, -3, 3, 1};
        int[] output = {3, 1};
        ListNode head = createLinkedListFromArray(input, 0);
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.removeZeroSumSublists(head)));
    }

    @Test
    public void checkTestcase2() {
        int[] input = {1, 2, 3, -3, 4};
        int[] output = {1, 2, 4};
        ListNode head = createLinkedListFromArray(input, 0);
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.removeZeroSumSublists(head)));
    }

    @Test
    public void checkTestcase3() {
        int[] input = {1, 2, 3, -3, -2};
        int[] output = {1};
        ListNode head = createLinkedListFromArray(input, 0);
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.removeZeroSumSublists(head)));
    }

    @Test
    public void checkTestcase4() { // 28 / 105 testcases passed
        int[] input = {5, -3, -4, 1, 6, -2, -5};
        int[] output = {5, -2, -5};
        ListNode head = createLinkedListFromArray(input, 0);
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.removeZeroSumSublists(head)));
    }

    @Test
    public void checkTestcase5() { // 95 / 105 testcases passed
        int[] input = {0, 1, -1};
        int[] output = {};
        ListNode head = createLinkedListFromArray(input, 0);
        ListNode expected = createLinkedListFromArray(output, 0);
        assertTrue(areLinkedListsEquals(expected, testingClass.removeZeroSumSublists(head)));
    }

    // создаёт Linked list (ListNode) из массива int
    private ListNode createLinkedListFromArray(int[] array, int index) {
        if (index >= array.length) return null;
        ListNode head = new ListNode(array[index++]);
        head.next = createLinkedListFromArray(array, index);
        return head;
    }

    // проверяет, что два ListNode равны друг другу
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

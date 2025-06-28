package matrix.workingPeoplesImitation.task_64_Rotate_List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(input);
        int k = 2;
        int[] output = {4, 5, 1, 2, 3};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    @Test
    public void checkTestcase2() {
        int[] input = {0, 1, 2};
        ListNode head = createLinkedList(input);
        int k = 4;
        int[] output = {2, 0, 1};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    @Test
    public void checkTestcase3() { // 2 / 232 testcases passed
        int[] input = {};
        ListNode head = createLinkedList(input);
        int k = 0;
        int[] output = {};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    @Test
    public void checkTestcase4() { // 25 / 232 testcases passed
        int[] input = {1};
        ListNode head = createLinkedList(input);
        int k = 1;
        int[] output = {1};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    @Test
    public void checkTestcase5() { // 27 / 232 testcases passed
        int[] input = {1, 2};
        ListNode head = createLinkedList(input);
        int k = 1;
        int[] output = {2, 1};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    @Test
    public void checkTestcase6() { // 30 / 232 testcases passed
        int[] input = {1, 2};
        ListNode head = createLinkedList(input);
        int k = 2;
        int[] output = {1, 2};
        ListNode expected = createLinkedList(output);
        assertTrue(areLinkedListEquals(expected, testingClass.rotateRight(head, k)));
    }

    private boolean areLinkedListEquals(ListNode expected, ListNode listNode) {
        while (expected != null && listNode != null) {
            if (expected.val != listNode.val) return false;
            expected = expected.next;
            listNode = listNode.next;
        }
        return expected == null && listNode == null;
    }

    private ListNode createLinkedList(int[] input) {
        if (input.length == 0) return null;
        ListNode head = new ListNode(input[0]);
        ListNode current = head;
        for (int i = 1; i < input.length; i++) {
            current.next = new ListNode(input[i]);
            current = current.next;
        }
        return head;
    }
}

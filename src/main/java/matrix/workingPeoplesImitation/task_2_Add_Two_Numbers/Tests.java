package matrix.workingPeoplesImitation.task_2_Add_Two_Numbers;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] l1 = {2, 4, 3}, l2 = {5, 6, 4};
        int[] expected = {7, 0, 8};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
    }

    @Test
    public void checkTestcase2() {
        int[] l1 = {0}, l2 = {0};
        int[] expected = {0};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
    }

    @Test
    public void checkTestcase3() {
        int[] l1 = {9, 9, 9, 9, 9, 9, 9}, l2 = {9, 9, 9, 9};
        int[] expected = {8, 9, 9, 9, 0, 0, 0, 1};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
    }

    @Test
    public void checkTestcase4() { // 16 / 1568 testcases passed
        int[] l1 = {2, 4, 9}, l2 = {5, 6, 4, 9};
        int[] expected = {7, 0, 4, 0, 1};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
    }

    @Test
    public void checkTestcase5() { // 792 / 1568 testcases passed
        int[] l1 = {9}, l2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
    }

    @Test
    public void checkTestcase6() { // 1565 / 1568 testcases passed
        int[] l1 = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, l2 = {5, 6, 4};
        int[] expected = {6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertTrue(areLinkedListsEquals(createLinkedListFromArray(expected, 0), testingClass.addTwoNumbers(createLinkedListFromArray(l1, 0), createLinkedListFromArray(l2, 0))));
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

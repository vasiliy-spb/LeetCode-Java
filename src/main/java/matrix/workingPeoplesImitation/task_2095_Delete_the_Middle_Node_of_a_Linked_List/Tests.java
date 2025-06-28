package matrix.workingPeoplesImitation.task_2095_Delete_the_Middle_Node_of_a_Linked_List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        ListNode expected = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(1, new ListNode(2, new ListNode(6))))));
        assertTrue(linkedListsEqual(expected, testingClass.deleteMiddle(head)));
    }

    @Test
    public void checkTestcase2() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(4)));
        assertTrue(linkedListsEqual(expected, testingClass.deleteMiddle(head)));
    }

    @Test
    public void checkTestcase3() {
        ListNode head = new ListNode(2, new ListNode(1));
        ListNode expected = new ListNode(2);
        assertTrue(linkedListsEqual(expected, testingClass.deleteMiddle(head)));
    }

    @Test
    public void checkTestcase4() { // 66 / 70 testcases passed
        ListNode head = new ListNode(1);
        ListNode expected = null;
        assertTrue(linkedListsEqual(expected, testingClass.deleteMiddle(head)));
    }

    private boolean linkedListsEqual(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == null && list2 == null;
    }
}

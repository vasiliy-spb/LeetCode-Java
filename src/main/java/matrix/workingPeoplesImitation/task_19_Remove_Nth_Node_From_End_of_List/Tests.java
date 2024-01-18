package matrix.workingPeoplesImitation.task_19_Remove_Nth_Node_From_End_of_List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 2;
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5))));
        testingClass.removeNthFromEnd(head, n);
        assertTrue(linkedListsEqual(expected, head));
    }

    @Test
    public void checkTestcase2() {
        ListNode head = new ListNode(1);
        int n = 1;
        ListNode expected = null;
//        testingClass.removeNthFromEnd(head, n);
        assertTrue(testingClass.removeNthFromEnd(head, n) == null);
    }

    @Test
    public void checkTestcase3() {
        ListNode head = new ListNode(1, new ListNode(2));
        int n = 1;
        ListNode expected = new ListNode(1);
        assertTrue(linkedListsEqual(expected, testingClass.removeNthFromEnd(head, n)));
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

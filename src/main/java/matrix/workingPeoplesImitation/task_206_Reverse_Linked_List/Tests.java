package matrix.workingPeoplesImitation.task_206_Reverse_Linked_List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

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

    @Test
    public void checkTestcase1() {
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode expectedOutput = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        assertTrue(linkedListsEqual(testingClass.reverseList(input), expectedOutput));
    }

    @Test
    public void checkTestcase2() {
        ListNode input = new ListNode(1, new ListNode(2));
        ListNode expectedOutput = new ListNode(2, new ListNode(1));
        assertTrue(linkedListsEqual(testingClass.reverseList(input), expectedOutput));
    }

}

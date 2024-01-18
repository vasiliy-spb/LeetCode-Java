package matrix.workingPeoplesImitation.task_2130_Maximum_Twin_Sum_of_a_Linked_List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        int expected = 6;
        assertEquals(expected, testingClass.pairSum(head));
    }

    @Test
    public void checkTestcase2() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        int expected = 7;
        assertEquals(expected, testingClass.pairSum(head));
    }

    @Test
    public void checkTestcase3() {
        ListNode head = new ListNode(1, new ListNode(100000));
        int expected = 100001;
        assertEquals(expected, testingClass.pairSum(head));
    }

}

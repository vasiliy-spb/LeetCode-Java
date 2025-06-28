package matrix.workingPeoplesImitation.task_234_Palindrome_Linked_List;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(testingClass.isPalindrome(head));
    }

    @Test
    public void checkTestcase2() {
        ListNode head = new ListNode(1, new ListNode(2));
        assertFalse(testingClass.isPalindrome(head));
    }

    @Test
    public void checkTestcase3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2,new ListNode(1)))));
        assertTrue(testingClass.isPalindrome(head));
    }

    @Test
    public void checkTestcase4() { // 79 / 93 testcases passed
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1))));
        assertFalse(testingClass.isPalindrome(head));
    }

}

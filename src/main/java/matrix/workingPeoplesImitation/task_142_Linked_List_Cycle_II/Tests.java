package matrix.workingPeoplesImitation.task_142_Linked_List_Cycle_II;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testExample1() {
        // Creating the linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating the cycle: tail connects to node index 1
        head.next.next.next.next = head.next;

        ListNode result = testingClass.detectCycle(head);
        assertNotNull(result);
        assertEquals(2, result.val);
    }

    @Test
    public void testExample2() {
        // Creating the linked list: 1 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        // Creating the cycle: tail connects to node index 0
        head.next.next = head;

        ListNode result = testingClass.detectCycle(head);
        assertNotNull(result);
        assertEquals(1, result.val);
    }

    @Test
    public void testExample3() {
        // Creating the linked list: 1
        ListNode head = new ListNode(1);

        // No cycle in the linked list
        ListNode result = testingClass.detectCycle(head);
        assertNull(result);
    }

    @Test
    public void testNoCycle() {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // No cycle in the linked list
        ListNode result = testingClass.detectCycle(head);
        assertNull(result);
    }

    @Test
    public void testSingleElementCycle() {
        // Creating the linked list: 1
        ListNode head = new ListNode(1);

        // Creating a cycle with a single element: tail connects to node index 0
        head.next = head;

        ListNode result = testingClass.detectCycle(head);
        assertNotNull(result);
        assertEquals(1, result.val);
    }

    @Test
    public void testLargeCycle() {
        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a larger cycle: tail connects to node index 2
        head.next.next.next.next.next = head.next.next;

        ListNode result = testingClass.detectCycle(head);
        assertNotNull(result);
        assertEquals(3, result.val);
    }

    @Test
    public void testNegativeValues() {
        // Creating the linked list: -1 -> -2 -> -3 -> -4 -> -5
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(-5);

        // No cycle in the linked list
        ListNode result = testingClass.detectCycle(head);
        assertNull(result);
    }

}

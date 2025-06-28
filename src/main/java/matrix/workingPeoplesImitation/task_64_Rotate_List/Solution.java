package matrix.workingPeoplesImitation.task_64_Rotate_List;

public class Solution {

    // my solution with comments from GPT
    public ListNode rotateRight(ListNode head, int k) {
        // Check if the list is empty, has only one node, or rotation is unnecessary
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the linked list and identify the tail node
        int length = 0;  // Variable to store the length of the linked list
        ListNode current = head;  // Pointer to traverse the linked list
        ListNode tail = null;  // Pointer to keep track of the tail node

        while (current != null) {
            length++;
            tail = current;
            current = current.next;
        }

        // Calculate the effective rotation by finding the new head position
        int size = length - 1 - k % length;

        // Step 2: Connect the tail to the head to create a circular linked list
        tail.next = head;

        // Step 3: Traverse the linked list to find the new tail node
        current = head;
        while (size > 0) {
            current = current.next;
            size--;
        }

        // Step 4: Disconnect the linked list at the new tail node
        ListNode newHead = current.next;  // The new head is the next node after the new tail
        current.next = null;  // Set the next of the new tail to null to break the circular structure

        // Step 5: Return the new head of the rotated linked list
        return newHead;
    }

    // from leetcode solutions
    public ListNode rotateRight2(ListNode head, int k) {
        ListNode fake = new ListNode(-1), slow = fake, fast = fake;
        fake.next = head;

        int len = 0;
        while (fast.next != null) {   // fast REACH tail && Count len
            fast = fast.next;
            len++;
        }
        if (len == 0) return null;   // CHECK null

        k %= len;
        for (int i = 0; i < len - k; i++)  // slow REACH before the rotated point
            slow = slow.next;

        fast.next = fake.next;      // CONNECT
        fake.next = slow.next;
        slow.next = null;

        return fake.next;
    }

    // from leetcode solutions
    // Since n may be a large number compared to the length of list. So we need to know the length of linked list.After that, move the list after the (l-n%l )th node to the front to finish the rotation.
    //
    // Ex: {1,2,3} k=2 Move the list after the 1st node to the front
    // Ex: {1,2,3} k=5, In this case Move the list after (3-5%3=1)st node to the front.
    // So the code has three parts.
    //  1) Get the length
    //  2) Move to the (l-n%l)th node
    //  3) Do the rotation
    public ListNode rotateRight3(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
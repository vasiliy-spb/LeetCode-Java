package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Random;

// from leetcode code sample (3)
public class Solution5 {
    ListNode head;
    Random random;

    public Solution5(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode current = head;
        int result = current.val;
        int count = 1;

        while (current != null) {
            if (random.nextInt(count) == count - 1) { // or: if (random.nextInt(count) == 0) {
                result = current.val;
            }
            current = current.next;
            count++;
        }

        return result;
    }
}

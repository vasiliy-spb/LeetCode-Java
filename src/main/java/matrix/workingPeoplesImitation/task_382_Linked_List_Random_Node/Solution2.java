package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Random;

// from walkccc.me
public class Solution2 {
    /**
     * @param head The linked list's head. Note that the head is guaranteed to be
     *             not null, so it contains at least one node.
     */
    public Solution2(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int res = -1;
        int i = 1;

        for (ListNode curr = head; curr != null; curr = curr.next, ++i)
            if (rand.nextInt(i) == i - 1)
                res = curr.val;

        return res;
    }

    private ListNode head;
    private Random rand = new Random();
}

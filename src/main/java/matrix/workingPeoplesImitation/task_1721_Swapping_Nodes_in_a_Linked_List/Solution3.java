package matrix.workingPeoplesImitation.task_1721_Swapping_Nodes_in_a_Linked_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (1)
public class Solution3 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head; // указывае на k эл сначала
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        // расстояние мд left и right будет k
        ListNode left = cur;
        ListNode right = head;
        while (cur.next != null) {
            cur = cur.next;
            right = right.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }
}

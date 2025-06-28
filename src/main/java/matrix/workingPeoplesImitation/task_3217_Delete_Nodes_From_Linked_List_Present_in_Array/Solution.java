package matrix.workingPeoplesImitation.task_3217_Delete_Nodes_From_Linked_List_Present_in_Array;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode newHead = null;
        ListNode current = null;
        while (head != null) {
            if (!set.contains(head.val)) {
                if (newHead == null) {
                    newHead = new ListNode(head.val);
                    current = newHead;
                } else {
                    current.next = new ListNode(head.val);
                    current = current.next;
                }
            }
            head = head.next;
        }
        return newHead;
    }
}

package matrix.workingPeoplesImitation.task_1721_Swapping_Nodes_in_a_Linked_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (2)
public class Solution4 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=1;i<k;i++){
            if (fast == null) {
                return head; // k exceeds the list length
            }
            fast=fast.next;
        }
        if (fast == null) {
            return head; // No need to swap (same node)
        }
        ListNode ter=fast;
        int temp=ter.val;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ter.val = slow.val;
        slow.val = temp;
        return head;
    }
}

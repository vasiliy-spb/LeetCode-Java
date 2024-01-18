package matrix.workingPeoplesImitation.task_19_Remove_Nth_Node_From_End_of_List;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        if (listNodeList.size() - n >= 1) listNodeList.get(listNodeList.size() - n - 1).next = listNodeList.get(listNodeList.size() - n).next;
        else return listNodeList.get(1);
        return listNodeList.get(0);
    }

    // from walkccc.me
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n-- > 0)
            fast = fast.next;
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    // from leetcode solutions
    //
    // A one pass solution can be done using pointers. Move one pointer fast --> n+1 places forward, to maintain a gap of n between the two pointers and then move both at the same speed. Finally, when the fast pointer reaches the end, the slow pointer will be n+1 places behind - just the right spot for it to be able to skip the next node.
    // Since the question gives that n is valid, not too many checks have to be put in place. Otherwise, this would be necessary.
    public ListNode removeNthFromEnd3(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            result.append(current.val).append(" — ");
            current = current.next;
        }
        return result.toString();
    }
}
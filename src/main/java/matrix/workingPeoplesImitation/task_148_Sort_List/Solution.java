package matrix.workingPeoplesImitation.task_148_Sort_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// my solution
public class Solution {
    public ListNode sortList(ListNode head) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        ListNode ans = queue.poll();
        ListNode current = ans;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            current.next = null;
        }
        return ans;
    }
}
package matrix.workingPeoplesImitation.task_148_Sort_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (1)
public class Solution4 {
    public ListNode sortList(ListNode head) {
        ListNode p = new ListNode(0, head);
        quickSort(p, null);
        return p.next;
    }

    private void quickSort(ListNode p, ListNode end) {
        if (p.next == null || p.next.next == null || p.next == end || p.next.next == end) {
            return;
        }

        ListNode mid = p.next;
        ListNode prev = mid;
        boolean isSorted = true;
        while (prev.next != end) {
            isSorted = isSorted && prev.val <= prev.next.val;
            if (prev.next.val < mid.val) {
                ListNode temp = prev.next;
                prev.next = prev.next.next;
                temp.next = p.next;
                p.next = temp;
            } else {
                prev = prev.next;
            }
        }

        if (isSorted) {
            return;
        }
        // sort left from p to mid, exclude both side
        this.quickSort(p, mid);
        // sort right from mid to end, exclude both side
        this.quickSort(mid, end);
    }
}

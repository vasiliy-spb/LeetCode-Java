package matrix.workingPeoplesImitation.task_148_Sort_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (2)
public class Solution5 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ListNode temp = head;

        while (temp != null) {
            min = Math.min(min, temp.val);
            max = Math.max(max, temp.val);
            temp = temp.next;
        }

        int[] count = new int[max - min + 1];
        temp = head;
        while (temp != null) {
            count[temp.val - min]++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                temp.val = i + min;
                temp = temp.next;
            }
        }
        return head;
    }
}

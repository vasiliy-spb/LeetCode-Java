package matrix.workingPeoplesImitation.task_445_Add_Two_Numbers_II;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (1)
public class Solution5 {
    public ListNode FixLength(ListNode l, int target_len, int len) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        len++;
        while (len < target_len) {
            ListNode tmp = new ListNode(0);
            cur.next = tmp;
            cur = tmp;
            len++;
        }
        cur.next = l;
        return res;
    }

    int left1 = 0;

    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode next = null;
        next = add(l1.next, l2.next);

        int tmp = l1.val + l2.val + left1;
        left1 = tmp / 10;
        tmp %= 10;

        return new ListNode(tmp, next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode x = l1;
        while (x.next != null) {
            x = x.next;
            len1++;
        }
        x = l2;
        while (x.next != null) {
            x = x.next;
            len2++;
        }
        if (len2 > len1) {
            l1 = FixLength(l1, len2, len1);
        } else if (len1 > len2) {
            l2 = FixLength(l2, len1, len2);
        }
        ListNode res = add(l1, l2);
        if (left1 > 0) {
            ListNode tmp = new ListNode(left1, res);
            res = tmp;
        }
        return res;
    }
}

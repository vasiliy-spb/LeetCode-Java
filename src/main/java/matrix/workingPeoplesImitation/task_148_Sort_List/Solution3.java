package matrix.workingPeoplesImitation.task_148_Sort_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode (https://leetcode.com/submissions/detail/1239016456/) решение от https://leetcode.com/Iregor/
public class Solution3 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return sortListRec(head, size);
    }

    private ListNode sortListRec(ListNode root, int size) {
        if (size == 1) {
            root.next = null;
            return root;
        }
        int i = 1;
        ListNode median = root;
        for (; i < size / 2; i++) {
            median = median.next;
        }
        ListNode rightRoot = median.next;
        ListNode left = sortListRec(root, i);
        ListNode right = sortListRec(rightRoot, size - i);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode root = null;
        if (left.val <= right.val) {
            root = left;
            left = left.next;
        } else {
            root = right;
            right = right.next;
        }
        ListNode median = root;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                median.next = left;
                median = median.next;
                left = left.next;
            } else {
                median.next = right;
                median = median.next;
                right = right.next;
            }
        }
        while (left != null) {
            median.next = left;
            median = median.next;
            left = left.next;
        }
        while (right != null) {
            median.next = right;
            median = median.next;
            right = right.next;
        }
        median.next = null;
        return root;
    }
}

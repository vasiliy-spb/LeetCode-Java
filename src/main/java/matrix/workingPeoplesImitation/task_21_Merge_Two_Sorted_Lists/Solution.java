package matrix.workingPeoplesImitation.task_21_Merge_Two_Sorted_Lists;

public class Solution {
    private class ListNode {
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
    }

    // my solution
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode current;
        if (list1.val < list2.val) {
            current = list1;
            list1 = list1.next;
        } else {
            current = list2;
            list2 = list2.next;
        }
        ListNode dummy = new ListNode(0, current);
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                current.next = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
            }
            current = current.next;
            current.next = null;
        }
        return dummy.next;
    }

    // from walkccc.me
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return list1 == null ? list2 : list1;
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        list1.next = mergeTwoLists2(list1.next, list2);
        return list1;
    }

}

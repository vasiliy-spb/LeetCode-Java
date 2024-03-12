package matrix.workingPeoplesImitation.task_1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

import java.util.*;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> intList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        while (head != null) {
            if (!sumList.isEmpty()) sumList.add(head.val + sumList.get(sumList.size() - 1));
            else sumList.add(head.val);
            intList.add(head.val);
            head = head.next;
        }
//        System.out.println("sumList = " + sumList);
//        System.out.println("intList = " + intList);
        if (sumList.contains(0)) {
            int start = sumList.lastIndexOf(0);
            for (int i = 0; i <= start; i++) {
                sumList.set(i, 0);
            }
        }
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) != 0) {
                if (sumList.lastIndexOf(sumList.get(i)) != i) {
                    int end = sumList.lastIndexOf(sumList.get(i));
                    for (int j = i + 1; j <= end; j++) {
                        sumList.set(j, 0);
                    }
                }
            }
        }
//        System.out.println(sumList);
        ListNode result = null;
        ListNode current = null;
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) != 0) {
                if (result == null) {
                    result = new ListNode(intList.get(i));
                } else if (current == null) {
                    current = new ListNode(intList.get(i));
                    result.next = current;
                } else {
                    current.next = new ListNode(intList.get(i));
                    current = current.next;
                }
            }
        }
        return result;
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
}
package matrix.workingPeoplesImitation.task_1669_Merge_In_Between_Linked_Lists;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode breakNode1 = null;
        ListNode continueNode1 = null;
        ListNode current = list1;
        int index = 1;
        while (current != null) {
            if (index == a) breakNode1 = current;
            if (index == b + 2) continueNode1 = current;
            current = current.next;
            index++;
        }
        breakNode1.next = list2;
        current = list2;
        while (current.next != null) {
            current = current.next;
        }
        current.next = continueNode1;
        return list1;
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

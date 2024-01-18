package matrix.workingPeoplesImitation.task_143_Reorder_List;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public void reorderList(ListNode head) {
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        ListNode result = null;
        ListNode resultHead = null;

        for (int i = 0, j = listNodeList.size() - 1; i <= j - i; i++) {
            result = listNodeList.get(i);
            System.out.println("result = " + result.val);
            if (resultHead == null) resultHead = result;
            if (i == j - i) break;
            ListNode temp = result.next;
            result.next = listNodeList.get(j - i);
            result.next.next = temp;
            result = result.next.next;
        }
        result.next = null;
    }

    // from walkccc.me
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = findMid(head);
        ListNode reversed = reverse(mid);
        merge(head, reversed);
    }

    private ListNode findMid(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }

    // from leetcode solutions
    public void reorderList3(ListNode head) {
        if (head == null || head.next == null) return;

        //Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    // from leetcode solutions (https://leetcode.com/problems/reorder-list/solutions/1640806/java-2-approach-2-pointer-approach/)
    public void reorderList4(ListNode head) {
        ListNode [] left =  new ListNode[1];// it will create in heap
        left[0]  =  head;
        reorder(left,head);

    }

    // left pointer will be created in heap and right pointer will be created in stack
    public void reorder(ListNode left[],ListNode right){
        if(right==null){
            return ;
        }
        reorder(left,right.next);

        // in post area of recursion right pointer coming back(because of function remove from recursion stack)
        // and we move left pointer forward
        if(left[0].next!=null){
            ListNode leftNext =  left[0].next;
            left[0].next =  right;
            right.next =  leftNext;
            left[0] =  leftNext;
        }

        // as we need to  merge till left pointer behind the right pointer
        if(left[0].next == right){
            left[0].next =  null;
        }
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
package matrix.workingPeoplesImitation.task_23_Merge_k_Sorted_Lists;

import java.util.*;

public class Solution {

    // my solution
    public ListNode mergeKLists(ListNode[] lists) {
        Set<Integer> keys = new HashSet<>();
        Map<Integer, List<ListNode>> map = new HashMap<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                keys.add(current.val);
                map.computeIfAbsent(current.val, list -> new ArrayList<>()).add(current);
                current = current.next;
            }
        }
        List<Integer> values = new ArrayList<>(keys.stream().toList());
        values.sort(Comparator.naturalOrder());
        ListNode root = null;
        ListNode current = null;
        for (int key : values) {
            List<ListNode> list = map.get(key);
            for (ListNode node : list) {
                if (root == null) {
                    root = node;
                    current = root;
                } else {
                    current.next = node;
                    current = current.next;
                }
                node.next = null;
            }
        }
        return root;
    }

    // from walkccc.me
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (final ListNode list : lists)
            if (list != null)
                minHeap.offer(list);

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            if (minNode.next != null)
                minHeap.offer(minNode.next);
            curr.next = minNode;
            curr = curr.next;
        }

        return dummy.next;
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
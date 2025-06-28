package matrix.workingPeoplesImitation.task_138_Copy_List_with_Random_Pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> oldNodeList = new ArrayList<>();
        List<Node> newNodeList = new ArrayList<>();
        Map<Node, Integer> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node current = newHead;
        Node oldHead = head;
        oldNodeList.add(oldHead);
        int index = 0;
        map.put(oldHead, index++);
        oldHead = oldHead.next;
        while (oldHead != null) {
            map.put(oldHead, index++);
            oldNodeList.add(oldHead);
            newNodeList.add(current);
            current.next = new Node(oldHead.val);
            current = current.next;
            oldHead = oldHead.next;
        }
        newNodeList.add(current);
        current = newHead;
        while (head != null) {
            int oldRandomIndex = map.getOrDefault(head.random, -1);
            if (oldRandomIndex >= 0) {
                current.random = newNodeList.get(oldRandomIndex);
            }
            current = current.next;
            head = head.next;
        }
        return newHead;
    }
}

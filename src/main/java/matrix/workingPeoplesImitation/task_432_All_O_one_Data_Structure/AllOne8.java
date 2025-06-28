package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (5)
public class AllOne8 {
    static class Node {
        String key;
        int freq;
        Node next;
        Node prev;

        Node(String key) {
            this.key = key;
            freq = 0;
        }

        Node(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }

    Node head;
    Node tail;

    Map<String, Node> nodes;

    public AllOne8() {
        head = new Node("", Integer.MIN_VALUE);
        tail = new Node("", Integer.MAX_VALUE);
        nodes = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        Node node = nodes.get(key);
        if (node == null) {
            node = new Node(key, 1);
            nodes.put(key, node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            return;
        }
        node.freq++;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node temp = node.next;
        while (temp.freq < node.freq) {
            temp = temp.next;
        }
        temp.prev.next = node;
        node.prev = temp.prev;
        node.next = temp;
        temp.prev = node;
    }

    public void dec(String key) {
        Node node = nodes.get(key);
        node.freq--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node.freq > 0) {
            Node temp = node.prev;
            while (temp.freq > node.freq) {
                temp = temp.prev;
            }
            node.next = temp.next;
            node.next.prev = node;
            temp.next = node;
            node.prev = temp;
        }
    }

    public String getMaxKey() {
        return tail.prev.key;
    }

    public String getMinKey() {
        return head.next.key;
    }
}

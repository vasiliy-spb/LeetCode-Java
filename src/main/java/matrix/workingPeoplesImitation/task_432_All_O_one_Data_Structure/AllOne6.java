package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;

// from leetcode code sample (3)
public class AllOne6 {
    static class Node {
        String s;
        int count;
        Node next;
        Node prev;

        public Node(String s, int count) {
            this.count = count;
            this.s = s;
        }
    }

    HashMap<String, Node> map;
    Node head;
    Node tail;

    public AllOne6() {
        map = new HashMap<>();
        head = new Node(null, Integer.MAX_VALUE);
        tail = new Node(null, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            // get the node
            Node n = map.get(key);
            // increment the count
            n.count++;
            // check the count with previous element
            Node p = n.prev;
            while (p.count < n.count) p = p.prev;

            // remove n from its position
            n.prev.next = n.next;
            n.next.prev = n.prev;

            // and place next to p
            p.next.prev = n;
            n.next = p.next;
            n.prev = p;
            p.next = n;
        } else {
            Node n = new Node(key, 1);
            map.put(key, n);
            // add this node at the tail
            n.prev = tail.prev;
            tail.prev.next = n;
            n.next = tail;
            tail.prev = n;
        }
    }

    public void dec(String key) {
        // get the node
        Node n = map.get(key);
        n.count--;
        if (n.count == 0) {
            map.remove(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
            return;
        }
        Node p = n.next;
        while (p.count > n.count) p = p.next;

        // delete n from position
        n.prev.next = n.next;
        n.next.prev = n.prev;

        // and place before p
        p.prev.next = n;
        n.prev = p.prev;
        n.next = p;
        p.prev = n;
    }

    public String getMaxKey() {
        if (head.next == tail) return "";
        else return (head.next.s);
    }

    public String getMinKey() {
        if (tail.prev == head) return "";
        else return (tail.prev.s);
    }
}

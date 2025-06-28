package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (4)
public class AllOne7 {
    private Map<String, Node> map;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne7() {
        map = new HashMap<>();
    }

    public void inc(String key) {
        // Adds a new node if doesn't exist, else increments it.
        if (!map.containsKey(key)) {
            Node node = new Node(key, 1);
            addNewNode(node);
            return;
        }

        Node node = map.get(key);
        node.count++;

        // While the node's count is less than the previous node's count, keep swapping.
        while (head.text != node.text && node.count > node.prev.count) {
            //this loop makes it not O(1) operation as our very first answer
            Node prev = node.prev;
            removeNode(node); //Remove from current position and save previous node.

            // And insert it in front of previous node.
            addNode(prev.prev, node, prev);

            // If prev was the head, then node is the new head.
            if (prev.text == head.text) head = node;
            // If the node was the tail, then the previous count is now the tail.
            if (node.text == tail.text) tail = prev;
        }
    }

    /**
     * Decrements an existing text by 1. If Key's count is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) return;

        Node node = map.get(key);
        node.count--;

        // Deletes the node if count is 0. Else decrements it.
        if (node.count == 0) {
            deleteNode(node);
            return;
        }

        // While the node is less than the next node, keep swapping it.
        while (tail.text != node.text && node.count < node.next.count) {

            // Remove from current position.
            Node next = node.next;
            removeNode(node);

            // And insert it behind next node.
            addNode(next, node, next.next);

            // If next node was the tail, then node is the new tail.
            if (next.text == tail.text) tail = node;
            // If the node was the head, then the next node is the new head.
            if (node.text == head.text) head = next;
        }
    }

    public String getMaxKey() {
        return head == null ? "" : head.text;
    }

    public String getMinKey() {
        return tail == null ? "" : tail.text;
    }

    /**
     * Adds node in between prev and next.
     */
    private void addNode(Node prev, Node node, Node next) {
        if (prev != null) prev.next = node;
        if (next != null) next.prev = node;

        node.next = next;
        node.prev = prev;
    }

    /**
     * Removes node from the list.
     */
    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        // Remove links to adjacent nodes.
        node.next = null;
        node.prev = null;

        // Link previous node to next node.
        if (next != null) next.prev = prev;
        if (prev != null) prev.next = next;

    }

    /**
     * Adds a new node into the list.
     */
    private void addNewNode(Node node) {
        // If the head is null, then the list was empty.
        if (head == null) {
            head = node;
            tail = node;
        }
        // Else add it on to the end of the list.
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        map.put(node.text, node);
    }

    /**
     * Deletes a node from the list and removes it from the map.
     */
    private void deleteNode(Node node) {
        // If node was the head, then new head must be the next node.
        if (head.text == node.text) {
            head = head.next;
        }
        // If node was the tail, then new tail must be previous node.
        if (tail.text == node.text) {
            tail = tail.prev;
        }
        removeNode(node);
        map.remove(node.text);
    }

    static class Node {
        String text;
        int count;
        Node next;
        Node prev;

        public Node(String text, int count) {
            this.text = text;
            this.count = count;
            next = null;
            prev = null;
        }
    }
}

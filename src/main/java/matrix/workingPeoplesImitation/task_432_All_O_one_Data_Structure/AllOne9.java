package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

// from leetcode code sample (6)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Approach - DLL + Map
// Time Complexity - O(1)
// Space Complexity - O(n)
public class AllOne9 {
    // Node stores the freq and all the associated keys
    class Node {
        int val;
        Set<String> keys = new HashSet<>();
        Node prev;
        Node next;

        Node(int x) {
            val = x;
        }

        // Add key with some frequency
        Node(int x, String key) {
            val = x;
            keys.add(key);
        }

        // Add key in existing node
        void addKey(String key) {
            keys.add(key);
        }

        // Remove key from existing node
        void removeKey(String key) {
            keys.remove(key);
        }

        public String toString() {
            return " { val: " + val + ", keys: " + keys + " } ";
        }
    }

    // Head and Tail is forming the DLL
    Node head;
    Node tail;
    Map<String, Node> keyMap;   // Key to Respective node map

    public AllOne9() {
        keyMap = new HashMap<>();

        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        // Get the associated node with the given key
        Node node = keyMap.get(key);
        // System.out.println("inc start:" + keyMap);

        if (node == null) { // if key doesn't exist
            // If this is the first ever key or next key's frequency is more than 1
            if (head.next.val == -1 || head.next.val > 1) {
                Node newNode = new Node(1, key);    // Create node

                Node next = head.next;  // Take the next reference

                // Update the next pointers
                head.next = newNode;
                newNode.next = next;

                // Update the prev pointers
                next.prev = newNode;
                newNode.prev = head;
            } else {    // If one or more keys already exist
                head.next.addKey(key);  // Add the key in existing node of freq 1
            }
            // Update the key map with existing node of freq 1
            keyMap.put(key, head.next);
        } else {    // if key exists
            Integer freq = node.val;

            if (node.next.val == freq + 1) {   // If next node has consecutive freq
                node.next.addKey(key);  // Add the key in next node

                keyMap.put(key, node.next); // Update the keymap with next node

                node.removeKey(key);    // Remove key from the current node
                if (node.keys.isEmpty()) {  // Cleanup if necessary
                    removeNode(node);
                }
            } else {    // If next node doesn't has consecutive freq
                Node newNode = new Node(freq + 1, key);

                Node next = node.next;

                // Update the next pointers
                node.next = newNode;
                newNode.next = next;

                // Update the prev pointers
                next.prev = newNode;
                newNode.prev = node;

                // Update the key with new node
                keyMap.put(key, newNode);

                node.removeKey(key);    // Remove key from the current node
                if (node.keys.isEmpty()) {  // Cleanup if necessary
                    removeNode(node);
                }
            }
        }
        // System.out.println("inc end:" + keyMap);
    }

    public void dec(String key) {
        // Get the associated node with the given key
        Node node = keyMap.get(key);
        Integer freq = node.val;

        // System.out.println("dec start:" + keyMap);

        // If previous node is head or freq is already 1
        if (freq == 1) {
            node.removeKey(key);    // Remove key from the current node
            if (node.keys.isEmpty()) {   // Cleanup if necessary
                removeNode(node);
            }

            keyMap.remove(key); // Remove the key from map
        }
        // If prev node has consecutive freq
        else if (node.prev.val == freq - 1) {
            node.prev.addKey(key);  // Add key to prev node
            keyMap.put(key, node.prev); // Update the key map to prev node

            node.removeKey(key);    // Remove key from the current node
            if (node.keys.isEmpty()) {   // Cleanup if necessary
                removeNode(node);
            }
        } else {    // If prev node doesn't has consecutive freq
            Node newNode = new Node(freq - 1, key);

            Node prev = node.prev;

            // Update the prev pointers
            node.prev = newNode;
            newNode.prev = prev;

            // Update the next pointers
            prev.next = newNode;
            newNode.next = node;

            keyMap.put(key, newNode);   // Update the key map to new node

            node.removeKey(key);    // Remove key from the current node
            if (node.keys.isEmpty()) {  // Cleanup if necessary
                removeNode(node);
            }
        }

        // System.out.println("dec end:" + keyMap);
    }

    // Remove the node and update the prev and next pointers
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        // Cleanup the useless references
        node.next = null;
        node.prev = null;
    }

    public String getMaxKey() {
        if (head.next.val == -1) {
            return "";
        }
        // Get the last key from tail
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next.val == -1) {
            return "";
        }
        // Get the first key from head
        return head.next.keys.iterator().next();
    }
}

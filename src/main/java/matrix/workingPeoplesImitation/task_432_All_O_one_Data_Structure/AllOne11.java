package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// from leetcode code sample (8)
public class AllOne11 {
    Node root;

    Map<String, Node> keyCount;

    public AllOne11() {

        root = new Node();
        root.next = root;
        root.prev = root;
        keyCount = new HashMap<>();

    }

    public void inc(String key) {
        Node current;
        Node next;
        //if key is not present : no exitsing node clean up is required
        if (!keyCount.containsKey(key)) {
            //new to add completely new node
            if (root.next == root || root.next.count > 1) {
                root.insert(new Node(key, 1));
                keyCount.put(key, root.next);
            } else {
                //some existing node with count+1
                root.next.keys.add(key);
                keyCount.put(key, root.next);
            }
        } else {
            // if present in map
            current = keyCount.get(key);
            next = current.next;

            // need to add new node
            if (next == root || next.count > current.count + 1) {
                current.insert(new Node(key, current.count + 1));
                keyCount.put(key, current.next);
            } else {
                // adjust in existing node only
                next.keys.add(key);
                keyCount.put(key, next);
            }

            // remove existing key if required
            current.keys.remove(key);
            if (current.keys.isEmpty()) {
                current.remove();
            }
        }


    }


    public void dec(String key) {
        Node current = keyCount.get(key);
        Node prev = current.prev;
        //
        if (!keyCount.containsKey(key)) return;
        if (current.count == 1) {
            //remove from map
            keyCount.remove(key);
        } else {
            //check if prev node needs to be created or updated
            if (prev == root || prev.count < current.count - 1) {
                prev.insert(new Node(key, current.count - 1));
                keyCount.put(key, prev.next);
            }
            //use existing only
            else {
                prev.keys.add(key);
                keyCount.put(key, prev);
            }

        }
        current.keys.remove(key);
        if (current.keys.isEmpty()) {
            current.remove();
        }


    }

    public String getMaxKey() {
        if (root.prev == root) return "";
        return root.prev.keys.iterator().next();

    }

    public String getMinKey() {
        if (root.prev == root) return "";
        return root.next.keys.iterator().next();

    }

    static class Node {
        Node prev, next;
        int count;
        Set<String> keys;

        // dummy node
        Node() {
            this.prev = null;
            this.next = null;
            count = 0;
            keys = new HashSet<>();
        }

        Node(String key, int count) {
            this.prev = null;
            this.next = null;
            this.count = count;
            this.keys = new HashSet<>();
            keys.add(key);
        }

        Node insert(Node node) {
            node.prev = this;
            node.next = this.next;
            this.next = node;
            node.next.prev = node;
            return node;
        }

        void remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
        }

    }
}

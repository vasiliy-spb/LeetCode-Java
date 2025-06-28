package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// from leetcode code sample (7)
public class AllOne10 {
    private class Node {
        Set<String> nodeSet;
        Node left;
        Node right;
        int count;

        public Node(int cnt) {
            count = cnt;
            nodeSet = new HashSet<>();
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> countNodeMp;
    private Map<String, Integer> keycountMp;

    public AllOne10() {
        countNodeMp = new HashMap();
        keycountMp = new HashMap();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    public void inc(String key) {
        if (keycountMp.containsKey(key)) {
            updateKeyCount(key, 1);
        } else {
            keycountMp.put(key, 1);
            if (head.right.count != 1) {
                addNodeAfter(new Node(1), head);
            }
            head.right.nodeSet.add(key);
            countNodeMp.put(1, head.right);
        }
    }

    public void dec(String key) {
        if (keycountMp.containsKey(key)) {
            int cnt = keycountMp.get(key);
            if (cnt == 1) {
                keycountMp.remove(key);
                removeKeyfromNode(countNodeMp.get(cnt), key);
            } else {
                updateKeyCount(key, -1);
            }
        }
    }

    private void updateKeyCount(String key, int offset) {
        int cnt = keycountMp.get(key);
        keycountMp.put(key, cnt + offset);
        Node node = countNodeMp.get(cnt);
        Node newNode;
        if (countNodeMp.containsKey(cnt + offset)) {
            newNode = countNodeMp.get(cnt + offset);
        } else {
            newNode = new Node(cnt + offset);
            countNodeMp.put(cnt + offset, newNode);
            Node addAfterNode;
            if (offset == 1) {
                addAfterNode = node;
            } else {
                addAfterNode = node.left;
            }
            addNodeAfter(newNode, addAfterNode);
        }
        newNode.nodeSet.add(key);
        removeKeyfromNode(node, key);
    }

    private void addNodeAfter(Node node, Node head) {
        node.left = head;
        node.right = head.right;
        head.right.left = node;
        head.right = node;
    }

    private void removeKeyfromNode(Node node, String key) {
        node.nodeSet.remove(key);
        if (node.nodeSet.size() == 0) {
            removeNode(node);
            countNodeMp.remove(node.count);
        }
    }

    private void removeNode(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
        node.left = null;
        node.right = null;
    }

    public String getMaxKey() {
        return tail.left == head ? "" : (String) tail.left.nodeSet.iterator().next();
    }

    public String getMinKey() {
        return head.right == tail ? "" : (String) head.right.nodeSet.iterator().next();
    }
}

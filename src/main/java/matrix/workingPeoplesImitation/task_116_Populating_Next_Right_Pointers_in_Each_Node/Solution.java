package matrix.workingPeoplesImitation.task_116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Node temp = null;
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                    queue.offer(current.right);
                    current.left.next = current.right;
                    if (temp != null) temp.next = current.left;
                    temp = current.right;
                }
            }
        }
        return root;
    }

    // from walkccc.me (Approach 1: Recursive)
    public Node connect2(Node root) {
        if (root == null)
            return null;
        connectTwoNodes(root.left, root.right);
        return root;
    }

    private void connectTwoNodes(Node p, Node q) {
        if (p == null)
            return;
        p.next = q;
        connectTwoNodes(p.left, p.right);
        connectTwoNodes(q.left, q.right);
        connectTwoNodes(p.right, q.left);
    }

    // from walkccc.me (Approach 2: Iterative)
    public Node connect3(Node root) {
        Node node = root; // the node that is above the current needling

        while (node != null && node.left != null) {
            Node dummy = new Node(); // a dummy node before needling
            // Needle the children of the node.
            for (Node needle = dummy; node != null; node = node.next) {
                needle.next = node.left;
                needle = needle.next;
                needle.next = node.right;
                needle = needle.next;
            }
            node = dummy.next; // Move the node to the next level.
        }

        return root;
    }

    // from leetcode solutions
    public Node connect4(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null) return;
        curr.next = next;
        dfs(curr.left, curr.right);
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    // from leetcode solutions
    public void connect5(Node root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect5(root.left);
        connect5(root.right);
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
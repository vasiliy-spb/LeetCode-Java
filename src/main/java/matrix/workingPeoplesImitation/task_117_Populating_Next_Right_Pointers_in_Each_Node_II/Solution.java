package matrix.workingPeoplesImitation.task_117_Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node current = nodeQueue.poll();
                if (i < size - 1) current.next = nodeQueue.peek();
                if (current.left != null) nodeQueue.offer(current.left);
                if (current.right != null) nodeQueue.offer(current.right);
            }
        }
        return root;
    }

    // my solution (wrong way)
    public Node connect1(Node root) {
        if (root == null) return root;
        ArrayDeque<Node> nodeQueue = new ArrayDeque<>();
        ArrayDeque<Boolean> isRightChildQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        isRightChildQueue.offer(false);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                while (size > 0 && !isRightChildQueue.getLast()) {
                    Node left = nodeQueue.pollLast();
                    isRightChildQueue.pollLast();
                    left.next = null;
                    if (left.right != null) {
                        nodeQueue.offerFirst(left.right);
                        isRightChildQueue.offerFirst(true);
                    }
                    if (left.left != null) {
                        nodeQueue.offerFirst(left.left);
                        isRightChildQueue.offerFirst(false);
                    }
                    size--;
                }
                if (size == 0) break;

                // 0,
                // 2,4,
                // 1,null,3,-1,
                // 5,1,null,6,null,8

                Node right = null;
                while (size > 0 && isRightChildQueue.getLast()) {
                    isRightChildQueue.pollLast();
                    Node current = nodeQueue.pollLast();
                    current.next = right;
                    right = current;
                    if (right.right != null) {
                        nodeQueue.offerFirst(right.right);
                        isRightChildQueue.offerFirst(true);
                    }
                    if (right.left != null) {
                        nodeQueue.offerFirst(right.left);
                        isRightChildQueue.offerFirst(false);
                    }
                    size--;
                }
                if (size == 0) break;

                while (size > 0 && !isRightChildQueue.getLast()) {
                    Node left = nodeQueue.pollLast();
                    isRightChildQueue.pollLast();
                    left.next = right;
                    if (left.right != null) {
                        nodeQueue.offerFirst(left.right);
                        isRightChildQueue.offerFirst(true);
                    }
                    if (left.left != null) {
                        nodeQueue.offerFirst(left.left);
                        isRightChildQueue.offerFirst(false);
                    }
                    size--;
                }
                if (size == 0) break;
            }
        }
        return root;
    }

    // from leetcode code sample (best by runtime)
    public Node connect3(Node root) {
        if(root==null) return root;
        if(root.left!=null && root.right!=null) root.left.next = root.right;
        if(root.left!=null && root.right==null && root.next!=null){
            root.left.next = helper(root.next);
        }
        if (root.right!=null && root.next!=null) root.right.next = helper(root.next);
        connect3(root.right);
        connect3(root.left);
        return root;
    }

    public Node helper(Node root){
        if(root==null) return root;
        if(root.left!=null) return root.left;
        if(root.right!=null) return root.right;
        return helper(root.next);
    }

    // from walkccc.me
    public Node connect4(Node root) {
        Node node = root; // the node that is above the current needling

        while (node != null) {
            Node dummy = new Node(); // a dummy node before needling
            // Needle the children of the node.
            for (Node needle = dummy; node != null; node = node.next) {
                if (node.left != null) { // Needle the left child.
                    needle.next = node.left;
                    needle = needle.next;
                }
                if (node.right != null) { // Needle the right child.
                    needle.next = node.right;
                    needle = needle.next;
                }
            }
            node = dummy.next; // Move the node to the next level.
        }

        return root;
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
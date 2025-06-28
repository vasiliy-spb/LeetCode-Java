package matrix.workingPeoplesImitation.task_331_Verify_Preorder_Serialization_of_a_Binary_Tree;

import java.util.Stack;

// my solution
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 1) {
            return preorder.equals("#");
        }
        String[] nodes = preorder.split(",");
        Stack<Node> stack = new Stack<>();
        int index = 0;
        stack.push(new Node(nodes[index++], 0));
        while (!stack.empty() && index < nodes.length) {
            Node current = stack.pop();
            if (current.val.equals("#")) {
                return false;
            }
            while (index < nodes.length && nodes[index].equals("#") && current.child < 2) {
                index++;
                current.child++;
            }
            if (current.child < 2) {
                stack.push(current);
                if (index < nodes.length) {
                    current.child++;
                    stack.push(new Node(nodes[index++], 0));
                }
            }
        }
        while (!stack.empty()) {
            Node current = stack.pop();
            if (current.child != 2) {
                return false;
            }
        }
        return index == nodes.length;
    }

    static final class Node {
        final String val;
        int child;

        Node(String val, int child) {
            this.val = val;
            this.child = child;
        }
    }
}

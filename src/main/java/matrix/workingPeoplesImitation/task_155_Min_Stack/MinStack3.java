package matrix.workingPeoplesImitation.task_155_Min_Stack;

import java.util.Stack;


// my solution (after hint)
public class MinStack3 {
    Stack<Node> stack;
    public MinStack3() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty()) stack.push(new Node(val, val));
        else stack.push(new Node(val, Math.min(val, stack.peek().min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

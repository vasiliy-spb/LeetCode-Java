package matrix.workingPeoplesImitation.task_232_Implement_Queue_using_Stacks;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> pseudoQueue;
    public MyQueue() {
        this.pseudoQueue = new Stack<>();
    }

    public void push(int x) {
        this.pseudoQueue.push(x);
    }

    public int pop() {
        Stack<Integer> reverse = new Stack<>();
        while (!this.pseudoQueue.empty()) {
            reverse.push(this.pseudoQueue.pop());
        }
        int result = reverse.pop();
        while (!reverse.empty()) {
            this.pseudoQueue.push(reverse.pop());
        }
        return result;
    }

    public int peek() {
        Stack<Integer> reverse = new Stack<>();
        while (!this.pseudoQueue.empty()) {
            reverse.push(this.pseudoQueue.pop());
        }
        int result = reverse.peek();
        while (!reverse.empty()) {
            this.pseudoQueue.push(reverse.pop());
        }
        return result;
    }

    public boolean empty() {
        return this.pseudoQueue.empty();
    }
}

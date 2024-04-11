package matrix.workingPeoplesImitation.task_155_Min_Stack;

import java.util.*;

// my solution (wrong way)
public class MinStack {
    Stack<Integer> stack;
    Map<Integer, Integer> map;
    PriorityQueue<Integer> queue;

    public MinStack() {
        this.stack = new Stack<>();
        this.map = new HashMap<>();
        this.queue = new PriorityQueue<>();
    }

    public void push(int val) {
        this.stack.push(val);
        this.queue.offer(val);
        this.map.merge(val, 1, Integer::sum);
    }

    public void pop() {
        int val = this.stack.pop();
        this.map.merge(val, -1, Integer::sum);
        this.queue.remove(val);
        if (this.map.getOrDefault(val, 0) <= 0) {
            this.map.remove(val);
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.queue.peek();
    }
}

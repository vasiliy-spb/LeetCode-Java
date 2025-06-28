package matrix.workingPeoplesImitation.task_341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */

// my solution
public class NestedIterator implements Iterator<Integer> {
    private final Stack<NestedInteger> nestedStack;
    private final Stack<Integer> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedStack = new Stack<>();
        this.stack = new Stack<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                nestedStack.push(nestedInteger);
            } else {
                if (!nestedInteger.getList().isEmpty()) {
                    nestedStack.addAll(nestedInteger.getList());
                }
            }
        }
        while (!nestedStack.empty()) {
            NestedInteger current = nestedStack.pop();
            if (current.isInteger()) {
                stack.push(current.getInteger());
            } else {
                if (!current.getList().isEmpty()) {
                    nestedStack.addAll(current.getList());
                }
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }
}

interface NestedInteger {

    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

package matrix.workingPeoplesImitation.task_150_Evaluate_Reverse_Polish_Notation;

import java.util.*;
import java.util.function.BinaryOperator;

public class Solution {

    // my solution
    public int evalRPN00(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
                int result;
                switch (token) {
                    case "+" -> {
                        int b = stack.pop();
                        int a = stack.pop();
                        result = a + b;
                    }
                    case "-" -> {
                        int b = stack.pop();
                        int a = stack.pop();
                        result = a - b;
                    }
                    case "*" -> {
                        int b = stack.pop();
                        int a = stack.pop();
                        result = a * b;
                    }
                    case "/" -> {
                        int b = stack.pop();
                        int a = stack.pop();
                        result = a / b;
                    }
                    default -> result = Integer.parseInt(token);
                }
                stack.push(result);
        }
        return stack.pop();
    }

    // my solution
    public int evalRPN0(String[] tokens) {
        Set<String> operators = Set.of("+","-","*","/");
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch (token) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    // from walkccc.me
    public int evalRPN2(String[] tokens) {
        final Map<String, BinaryOperator<Long>> op = Map.of(
                "+", (a, b) -> a + b, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
        Deque<Long> stack = new ArrayDeque<>();

        for (final String token : tokens)
            if (op.containsKey(token)) {
                final long b = stack.pop();
                final long a = stack.pop();
                stack.push(op.get(token).apply(a, b));
            } else {
                stack.push(Long.parseLong(token));
            }

        return stack.pop().intValue();
    }

    // from leetcode solutions
    public int evalRPN3(String[] a) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(a[i]));
            }
        }

        return stack.pop();
    }

}

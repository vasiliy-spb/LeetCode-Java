package matrix.workingPeoplesImitation.task_227_Basic_Calculator_II;

import java.util.Stack;
import java.util.function.BiFunction;

public class Solution {

    // my solution
    public int calculate(String s) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<Integer, Integer, Integer> divide = (a, b) -> (int) a / b;
        s = s.replace(" ", "");
        Stack<String> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        char operator = '\0';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                if (i == s.length() - 1) num.append(ch);
                switch (operator) {
                    case '+', '\0' -> stack.push(num.toString());
                    case '-' -> stack.push("-" + num);
                    case '*' ->
                            stack.push(String.valueOf(multiply.apply(Integer.parseInt(stack.pop()), Integer.parseInt(num.toString()))));
                    case '/' ->
                            stack.push(String.valueOf(divide.apply(Integer.parseInt(stack.pop()), Integer.parseInt(num.toString()))));
                }
                operator = ch;
                num.setLength(0);
            } else {
                num.append(ch);
            }
        }
        return stack.stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }
}

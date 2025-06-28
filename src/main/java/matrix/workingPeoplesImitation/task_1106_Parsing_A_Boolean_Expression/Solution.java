package matrix.workingPeoplesImitation.task_1106_Parsing_A_Boolean_Expression;

import java.util.Map;
import java.util.function.Function;

// my solution
public class Solution {
    Map<Character, Function<String[], Boolean>> functions = Map.of(
            '|', new Function<>() {
                @Override
                public Boolean apply(String[] operators) {
                    for (String operator : operators) {
                        if (operator.equals("t")) {
                            return true;
                        }
                    }
                    return false;
                }
            },
            '&', new Function<>() {
                @Override
                public Boolean apply(String[] operators) {
                    for (String operator : operators) {
                        if (operator.equals("f")) {
                            return false;
                        }
                    }
                    return true;
                }
            },
            '!', new Function<>() {
                @Override
                public Boolean apply(String[] operators) {
                    return !operators[0].equals("t");
                }
            }
    );

    public boolean parseBoolExpr(String expression) {
        int open = expression.indexOf('(');
        int innerOpen = expression.lastIndexOf('(');
        if (open != innerOpen) {
            int innerClose = expression.indexOf(')', innerOpen);
            char inner = parseBoolExpr(expression.substring(innerOpen - 1, innerClose + 1)) ? 't' : 'f';
            return parseBoolExpr(expression.substring(0, innerOpen - 1) + inner + expression.substring(innerClose + 1));
        }
        int close = expression.lastIndexOf(')');
        char operator = expression.charAt(0);
        String[] args = expression.substring(open + 1, close).split(",");
        return functions.get(operator).apply(args);
    }
}

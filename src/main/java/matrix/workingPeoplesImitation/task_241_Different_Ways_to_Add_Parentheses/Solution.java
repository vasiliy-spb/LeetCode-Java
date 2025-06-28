package matrix.workingPeoplesImitation.task_241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

// my solution (accepted)
// I solved this problem after hint from GPT
public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        calculateExpression(expression);

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch)) {
                String prefix = expression.substring(0, i);
                String suffix = expression.substring(i + 1);
                List<Integer> prefixList = cache.get(prefix);
                List<Integer> suffixList = cache.get(suffix);
                if (prefixList == null || suffixList == null) {
                    continue;
                }
                for (int a : prefixList) {
                    for (int b : suffixList) {
                        ans.add(operations.get(ch).apply(a, b));
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }

    private List<Integer> calculateExpression(String expression) {
        if (cache.containsKey(expression)) {
            return cache.get(expression);
        }
        boolean hasOnlyNumber = true;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch)) {
                hasOnlyNumber = false;
                List<Integer> prefixes = calculateExpression(expression.substring(0, i));
                List<Integer> suffixes = calculateExpression(expression.substring(i + 1));
                for (int prefix : prefixes) {
                    for (int suffix : suffixes) {
                        cache.computeIfAbsent(expression, list -> new ArrayList<>()).add(operations.get(ch).apply(prefix, suffix));
                    }
                }
            }
        }
        if (hasOnlyNumber) {
            cache.computeIfAbsent(expression, list -> new ArrayList<>()).add(Integer.parseInt(expression));
        }
        return cache.get(expression);
    }

    private final Map<String, List<Integer>> cache = new HashMap<>();

    private static final Map<Character, BiFunction<Integer, Integer, Integer>> operations = Map.of(
            '+', new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer num1, Integer num2) {
                    return num1 + num2;
                }
            },
            '-', new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer num1, Integer num2) {
                    return num1 - num2;
                }
            },
            '*', new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer num1, Integer num2) {
                    return num1 * num2;
                }
            }
    );
}

package matrix.workingPeoplesImitation.task_241_Different_Ways_to_Add_Parentheses;

import java.util.*;
import java.util.function.BiFunction;

// my solution (WA)
public class Solution3 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        calculateExpression(expression);
//        System.out.println("cache = " + cache);

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
//            System.out.println("ans = " + ans);
            if (!Character.isDigit(ch)) {
                String prefix = expression.substring(0, i);
                String suffix = expression.substring(i + 1);
//                System.out.println("prefix = " + prefix);
//                System.out.println("suffix = " + suffix);
                Set<Integer> prefixSet = cache.get(prefix);
                Set<Integer> suffixSet = cache.get(suffix);
                if (prefixSet == null && suffixSet == null) {
                    continue;
                }
                if (prefixSet == null) {
                    ans.addAll(suffixSet);
                    continue;
                }
                if (suffixSet == null) {
                    ans.addAll(prefixSet);
                    continue;
                }
                for (int a : prefixSet) {
                    for (int b : suffixSet) {
                        ans.add(operations.get(ch).apply(a, b));
                    }
                }
//                System.out.println();
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(expression));
        }
//        System.out.println("ans = " + ans);
        return ans;
    }

    private final Map<String, Set<Integer>> cache = new HashMap<>();
    private int calculateExpression(String expression) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch)) {
                ans = operations.get(ch).apply(calculateExpression(expression.substring(0, i)), calculateExpression(expression.substring(i + 1)));
                cache.computeIfAbsent(expression, set -> new HashSet<>()).add(ans);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            cache.computeIfAbsent(expression, set -> new HashSet<>()).add(Integer.parseInt(expression));
            return Integer.parseInt(expression);
        }
        return ans;
    }
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

package matrix.workingPeoplesImitation.task_241_Different_Ways_to_Add_Parentheses;

import java.util.*;
import java.util.function.BiFunction;

// my solution (draft)
public class Solution2 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        calculateExpression(expression);

//        System.out.println("expression = " + expression);
//        System.out.println("cache = " + cache);

        // expression = 2-1-1-1-1
        // Expected :   [-2, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 4]
        // Actual   :   [-2, 0, 0, 0, 0,       2, 2, 2, 2,       4]
        // Difference:  [                0, 0              2, 2   ]

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (!Character.isDigit(ch)) {
                String prefix = expression.substring(0, i);
                String suffix = expression.substring(i + 1);
                List<Integer> prefixList = cache.get(prefix);
                List<Integer> suffixList = cache.get(suffix);
                if (prefixList == null || suffixList == null) {
                    System.out.println("prefixList == null || suffixList == null");
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

    ////////////////////////////////// with bugfis from GPT ////////////////////////////////////////
//    private List<Integer> calculateExpression(String expression) {
//        if (cache.containsKey(expression)) {
//            return cache.get(expression);
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < expression.length(); i++) {
//            char ch = expression.charAt(i);
//            if (!Character.isDigit(ch)) {
//                List<Integer> leftResults = calculateExpression(expression.substring(0, i));
//                List<Integer> rightResults = calculateExpression(expression.substring(i + 1));
//
//                for (int left : leftResults) {
//                    for (int right : rightResults) {
//                        result.add(operations.get(ch).apply(left, right));
//                    }
//                }
//            }
//        }
//
//        // Если выражение — это просто число, возвращаем его как результат
//        if (result.isEmpty()) {
//            result.add(Integer.parseInt(expression));
//        }
//
//        // Кэшируем результаты
//        cache.put(expression, result);
//        return result;
//    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private final Map<String, List<Integer>> cache = new HashMap<>();
//    private int calculateExpression(String expression) {
//        int ans = Integer.MAX_VALUE;
//        boolean needToAdd = !cache.containsKey(expression);
//        List<Integer> currentList = new ArrayList<>();
//        for (int i = 0; i < expression.length(); i++) {
//            char ch = expression.charAt(i);
//            if (!Character.isDigit(ch)) {
//                ans = operations.get(ch).apply(calculateExpression(expression.substring(0, i)), calculateExpression(expression.substring(i + 1)));
//                if (needToAdd) {
////                    cache.computeIfAbsent(expression, list -> new ArrayList<>()).add(ans);
//                }
//                currentList.add(ans);
//            }
//        }
////        if (needToAdd && currentList.size() > cache.getOrDefault(expression, new ArrayList<>()).size()) {
////            cache.put(expression, currentList);
////        }
////        if (needToAdd && currentList.size() > 0) {
////            int size = currentList.size() - 1;
////            while (size-- > 0) {
////                cache.computeIfAbsent(expression, list -> new ArrayList<>()).addAll(currentList);
////            }
////        }
//        if (ans == Integer.MAX_VALUE) {
//            if (needToAdd) {
//                cache.computeIfAbsent(expression, list -> new ArrayList<>()).add(Integer.parseInt(expression));
//            }
//            return Integer.parseInt(expression);
//        }
////        if (
//////                needToAdd
//////                &&
////                currentList.size() > cache.getOrDefault(expression, new ArrayList<>()).size()
////        ) {
//////            cache.put(expression, currentList);
////            cache.computeIfAbsent(expression, list -> new ArrayList<>()).addAll(currentList);
////        }
//        return ans;
//    }

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
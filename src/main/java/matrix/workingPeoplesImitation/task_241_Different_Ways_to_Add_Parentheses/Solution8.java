package matrix.workingPeoplesImitation.task_241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.List;

// from leetcode solutions (1)
// https://leetcode.com/problems/different-ways-to-add-parentheses/solutions/5806448/beats-90-beginner-friendly-python3-java-c-c-rust-go-js/?envType=daily-question&envId=2024-09-19
public class Solution8 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) {
                    for (int b : s2) {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }
}

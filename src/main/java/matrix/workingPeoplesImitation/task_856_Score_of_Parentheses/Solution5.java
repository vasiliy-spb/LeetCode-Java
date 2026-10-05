package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

import java.util.Stack;

// from leetcode code sample (4)
public class Solution5 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(1, score * 2);
            }
        }
        return score;
    }
}

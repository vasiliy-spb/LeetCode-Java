package matrix.workingPeoplesImitation.task_856_Score_of_Parentheses;

// from leetcode code sample (2)
public class Solution3 {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int openBracket = 0;
        boolean seenFirstClosingBracket = false;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!seenFirstClosingBracket) {
                    seenFirstClosingBracket = true;
                    score = score + (int) Math.pow(2, openBracket - 1);
                }
                openBracket--;
            } else {
                openBracket++;
                seenFirstClosingBracket = false;
            }
        }
        return score;
    }
}

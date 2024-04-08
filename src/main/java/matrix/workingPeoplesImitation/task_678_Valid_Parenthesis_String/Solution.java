package matrix.workingPeoplesImitation.task_678_Valid_Parenthesis_String;

public class Solution {

    // my solution
    public boolean checkValidString(String s) {
        int openBracketsCount = 0;
        int closeBracketsCount = 0;
        int variableBracketsCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') variableBracketsCount++;
            if (s.charAt(i) == '(') openBracketsCount++;
            if (s.charAt(i) == ')') {
                closeBracketsCount++;
                if (closeBracketsCount > openBracketsCount + variableBracketsCount) return false;
            }
        }
        openBracketsCount = 0;
        closeBracketsCount = 0;
        variableBracketsCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') variableBracketsCount++;
            if (s.charAt(i) == ')') closeBracketsCount++;
            if (s.charAt(i) == '(') {
                openBracketsCount++;
                if (openBracketsCount > closeBracketsCount + variableBracketsCount) return false;
            }
        }
        return true;
    }

    // from walkccc.me
    public boolean checkValidString2(final String s) {
        int low = 0;  // the lower bound of the number of valid '('s
        int high = 0; // the upper bound of the number of valid '('s

        for (final char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    ++low;
                    ++high;
                    break;
                case ')':
                    low = Math.max(0, --low);
                    --high;
                    break;
                case '*':
                    low = Math.max(0, --low);
                    ++high;
                    break;
            }
            if (high < 0)
                return false;
        }

        return low == 0;
    }
}

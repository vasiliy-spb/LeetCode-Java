package matrix.workingPeoplesImitation.task_1249_Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removingIndex = new HashSet<>();
        int openBracketsCount = 0;
        int closeBracketsCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openBracketsCount++;
            if (s.charAt(i) == ')') {
                if (closeBracketsCount == openBracketsCount) removingIndex.add(i);
                else closeBracketsCount++;
            }
        }
        openBracketsCount = 0;
        closeBracketsCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (removingIndex.contains(i)) continue;
            if (s.charAt(i) == ')') closeBracketsCount++;
            if (s.charAt(i) == '(') {
                if (closeBracketsCount == openBracketsCount) removingIndex.add(i);
                else openBracketsCount++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (removingIndex.contains(i)) continue;
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    // from walkccc.me
    public String minRemoveToMakeValid2(String s) {
        Deque<Integer> stack = new ArrayDeque<>(); // unpaired '(' indices
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); ++i)
            if (sb.charAt(i) == '(') {
                stack.push(i); // Record the unpaired '(' index.
            } else if (sb.charAt(i) == ')') {
                if (stack.isEmpty())
                    sb.setCharAt(i, '#'); // Mark the unpaired ')' as '#'.
                else
                    stack.pop(); // Find a pair!
            }

        // Mark the unpaired '(' as '#'.
        while (!stack.isEmpty())
            sb.setCharAt(stack.pop(), '#');

        return sb.toString().replaceAll("#", "");
    }
}

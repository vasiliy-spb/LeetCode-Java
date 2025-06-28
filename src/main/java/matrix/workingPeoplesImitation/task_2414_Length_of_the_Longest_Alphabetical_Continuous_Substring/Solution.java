package matrix.workingPeoplesImitation.task_2414_Length_of_the_Longest_Alphabetical_Continuous_Substring;

public class Solution {
    // my solution
    public int longestContinuousSubstring(String s) {
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1)
                maxLength = Math.max(maxLength, ++currentLength);
            else
                currentLength = 1;
        }
        return maxLength;
    }

    // from leetcode solutions
    public int longestContinuousSubstring2(String s) {
        int x = 0, len = 0, res = 0;
        for (char ch : s.toCharArray()) {
            len = ch - 'a' - x == 1 ? len + 1 : 1;  // add to len or restart
            res = Math.max(res, len);
            x = ch - 'a';
        }
        return res;
    }
}

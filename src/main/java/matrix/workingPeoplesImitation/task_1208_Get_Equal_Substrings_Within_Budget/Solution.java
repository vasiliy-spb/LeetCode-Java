package matrix.workingPeoplesImitation.task_1208_Get_Equal_Substrings_Within_Budget;

import java.util.Arrays;

public class Solution {

    // my solution
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int count = 0;
        int left = 0;
        int right = 0;
        int current = 0;
        while (right < n && left <= right) {
            if (maxCost >= diff[right]) {
                maxCost -= diff[right++];
                current++;
                count = Math.max(count, current);
            } else {
                if (left == right) {
                    maxCost -= diff[right++];
                } else {
                    maxCost += diff[left++];
                    current = Math.max(current - 1, 0);
                }
            }
        }
        return count;
    }

    // from leetcode editorial (Approach: Sliding Window)
    public int equalSubstring2(String s, String t, int maxCost) {
        int N = s.length();

        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;

        for (int i = 0; i < N; i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));

            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    // from walkccc.me
    public int equalSubstring3(String s, String t, int maxCost) {
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            maxCost -= Math.abs(s.charAt(i) - t.charAt(i));
            if (maxCost < 0)
                maxCost += Math.abs(s.charAt(j) - t.charAt(j++));
        }

        return s.length() - j;
    }

}

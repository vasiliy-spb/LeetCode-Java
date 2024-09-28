package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.Arrays;

// from leetcode code sample (3)
// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/solutions/4480938/top-three-longest-special-substring/
public class Solution10 {
    public int maximumLength(String s) {
        // top three longest length of each char
        int[][] count = new int[26][3];
        final int n = s.length();
        for (int i = 0, j = 0; i < n; i = j) {
            char c = s.charAt(i);
            // count the length of special substring
            while (j < n && s.charAt(j) == c) {
                j++;
            }

            // save the top three longest length
            int[] t = count[c - 'a'];
            Arrays.sort(t);
            t[0] = Math.max(t[0], j - i);
        }

        int result = -1;
        for (int[] p : count) {
            Arrays.sort(p);
            int a = p[0];
            int b = p[1];
            int c = p[2];

            // invalid special substring
            // [0, 1 ,1]
            // [0, 0 ,2]
            if (a + b + c < 3) {
                continue;
            }

            if (a == b && a == c) {
                // pick top three special substring
                result = Math.max(result, c);
            }

            if (c == b + 1 || c == b) {
                // pick top two special substring
                result = Math.max(result, c - 1);
            } else {
                // pick top one special substring
                result = Math.max(result, c - 2);
            }
        }

        return result;
    }
}

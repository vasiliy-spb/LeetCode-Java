package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.Arrays;

// from leetcode code sample (3)
public class Solution5 {
    public int maximumLength(String s) {
        int[][] freq = new int[26][3];

        for (int i = 0, j = 0; i < s.length(); i = j) {
            char c = s.charAt(j);
            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }

            int len = j - i;

            int[] t = freq[c - 'a'];
            Arrays.sort(t);
            t[0] = Math.max(t[0], len);
        }

        int res = -1;
        for (int[] f : freq) {
            Arrays.sort(f);
            int a = f[0];
            int b = f[1];
            int c = f[2];

            if (a + b + c < 3) {
                continue;
            }
            if (a == b && a == c) {
                res = Math.max(res, a);
            }
            if (c == b + 1 || c == b) {
                res = Math.max(res, c - 1);
            } else {
                res = Math.max(res, c - 2);
            }
        }
        return res;
    }
}

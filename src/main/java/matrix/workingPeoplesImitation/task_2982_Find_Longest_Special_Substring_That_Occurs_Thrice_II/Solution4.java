package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

import java.util.Arrays;

// from leetcode code sample (2)
public class Solution4 {
    public int maximumLength(String s) {
        int idx = 0;
        int[][] count = new int[26][3];

        while (idx < s.length()) {
            char curr = s.charAt(idx);
            int nxt = idx + 1;
            while (nxt < s.length() && curr == s.charAt(nxt)) {
                nxt += 1;
            }

            int[] top3 = count[curr - 'a'];
            Arrays.sort(top3);
            top3[0] = nxt - idx;

            idx = nxt;
        }

        int res = -1;
        for (int i = 0; i < count.length; i++) {
            int[] currFreq = count[i];
            Arrays.sort(currFreq);
            int a = currFreq[0];
            int b = currFreq[1];
            int c = currFreq[2];

            if (a + b + c < 3) {
                continue;
            }

            if (a == b && b == c) {
                res = Math.max(a, res);
            } else if (c == b + 1 || c == b) {
                res = Math.max(res, c - 1);
            } else {
                res = Math.max(res, c - 2);
            }
        }


        return res;
    }
}

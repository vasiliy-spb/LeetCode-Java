package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import java.util.Arrays;

// from leetcode code sample (2)
public class Solution5 {
    public int findTheLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int state = 0;
        int[] pos = new int[32];
        Arrays.fill(pos, -2);
        pos[0] = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            switch (chars[i]) {
                case 'a':
                    state ^= 1;
                    break;
                case 'e':
                    state ^= 2;
                    break;
                case 'i':
                    state ^= 4;
                    break;
                case 'o':
                    state ^= 8;
                    break;
                case 'u':
                    state ^= 16;
                    break;
            }
            if (pos[state] < -1) {
                pos[state] = i;
            } else {
                res = Math.max(res, i - pos[state]);
            }
        }
        return res;
    }
}

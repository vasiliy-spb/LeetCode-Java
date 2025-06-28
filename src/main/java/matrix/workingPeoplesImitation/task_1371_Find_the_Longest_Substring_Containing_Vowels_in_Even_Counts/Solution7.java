package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import java.util.Arrays;

// from leetcode code sample (4)
public class Solution7 {
    public int findTheLongestSubstring(String s) {
        int[] prefix = new int[32];
        int res = 0;
        int mask = 0;
        Arrays.fill(prefix, s.length());
        prefix[0] = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                mask ^= 1;
            } else if (c == 'e') {
                mask ^= 2;
            } else if (c == 'i') {
                mask ^= 4;
            } else if (c == 'o') {
                mask ^= 8;
            } else if (c == 'u') {
                mask ^= 16;
            }
            if (prefix[mask] == s.length()) {
                prefix[mask] = i;
            } else {
                int last = prefix[mask];
                res = Math.max(res, i - last);
            }
        }
        return res;
    }
}

package matrix.workingPeoplesImitation.task_1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts;

import java.util.Arrays;

// from leetcode code sample (1)
public class Solution4 {
    static boolean[] isVowel = new boolean[]{true, false, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, false, false};
    static int[] xor = new int[]{1, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0};

    public int findTheLongestSubstring(String s) {
        int[] earliest = new int[32];
        Arrays.fill(earliest, -2);
        earliest[0] = -1;
        char[] cs = s.toCharArray();
        int key = 0;
        int longest = 0;
        for (int i = 0; i < cs.length; i++) {
            if (isVowel[cs[i] - 'a']) key ^= xor[cs[i] - 'a'];
            if (earliest[key] == -2) earliest[key] = i;
            else {
                int len = i - earliest[key];
                if (len > longest) longest = len;
            }
        }
        return longest;
    }
}

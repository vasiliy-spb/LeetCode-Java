package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

// from leetcode code sample (3)
public class Solution5 {
    public int maximumLength(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] charWithLen = new int[26][s.length()];

        int res = -1;
        int start = 0;
        int end = 0;
        while(start < s.length()) {
            while (end < s.length() && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            int len = end - start;
            for (int i = 0; i < len; i++) {
                charWithLen[s.charAt(start)-'a'][i] += len-i;
                if (charWithLen[s.charAt(start)-'a'][i] >= 3) {
                    res = Math.max(res, i+1);
                }
            }
            start = end;
        }

        return res;
    }
}

package matrix.workingPeoplesImitation.task_2311_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K;

// from walkccc.me
public class Solution3 {
    public int longestSubsequence(String s, int k) {
        int oneCount = 0;
        int num = 0;
        int pow = 1;

        // Take as many 1s as possible from the right.
        for (int i = s.length() - 1; i >= 0 && num + pow <= k; --i) {
            if (s.charAt(i) == '1') {
                ++oneCount;
                num += pow;
            }
            pow *= 2;
        }

        return (int) s.chars().filter(c -> c == '0').count() + oneCount;
    }
}

package matrix.workingPeoplesImitation.task_2311_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K;

public class Solution {
    // my solution
    public int longestSubsequence(String s, int k) {
        int kLength = Integer.toBinaryString(k).length();
        if (s.length() <= kLength) {
            return Integer.parseInt(s, 2) <= k ? s.length() : s.length() - 1;
        }
        int tail = Integer.parseInt(s.substring(s.length() - kLength), 2);
        int count = tail <= k ? kLength : kLength - 1;
        for (int i = s.length() - count - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }
}

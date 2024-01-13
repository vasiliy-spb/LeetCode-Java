package matrix.workingPeoplesImitation.task_392_Is_Subsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int subIndex = 0;
        for (int i = 0; i < t.length() && subIndex < s.length(); i++) {
            if (t.charAt(i) == s.charAt(subIndex)) subIndex++;
        }
        return subIndex == s.length();
    }
}

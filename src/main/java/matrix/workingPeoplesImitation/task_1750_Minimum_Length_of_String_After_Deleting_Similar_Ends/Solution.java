package matrix.workingPeoplesImitation.task_1750_Minimum_Length_of_String_After_Deleting_Similar_Ends;

public class Solution {
    // my solution
    public int minimumLength(String s) {
        int l = 0;
        int r = s.length() - 1;
        boolean odd = true;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if (left == right) odd = (r - l) == 2;
            while (l < r && s.charAt(l) == left) l++;
            while (l < r && s.charAt(r) == right) r--;
        }
        if (l == r) return odd ? 1 : 0;
        return s.substring(l, r + 1).length();
    }

    // from walkccc.me
    public int minimumLength1(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            final char c = s.charAt(i);
            while (i <= j && s.charAt(i) == c)
                ++i;
            while (i <= j && s.charAt(j) == c)
                --j;
        }

        return j - i + 1;
    }

    // from leetcode editorial (Approach 1: Two Pointers) Implementation 1: Iterative
    public int minimumLength2(String s) {
        int begin = 0;
        int end = s.length() - 1;

        // Delete similar ends until the ends differ or they meet in the middle
        while (begin < end && s.charAt(begin) == s.charAt(end)) {
            char c = s.charAt(begin);

            // Delete consecutive occurrences of c from prefix
            while (begin <= end && s.charAt(begin) == c) {
                begin++;
            }

            // Delete consecutive occurrences of c from suffix
            while (end > begin && s.charAt(end) == c) {
                end--;
            }
        }

        // Return the number of remaining characters
        return end - begin + 1;
    }

    // from leetcode editorial (Approach 1: Two Pointers) Implementation 2: Tail Recursion
    public int minimumLength3(String s) {
        return deleteSimilarEnds(s, 0, s.length() - 1);
    }

    // Deletes similar ends and returns remaining length
    private int deleteSimilarEnds(String s, int begin, int end) {
        // The ends differ or meet in the middle
        if (begin >= end || s.charAt(begin) != s.charAt(end)) {
            return end - begin + 1;
        } else {
            char c = s.charAt(begin);

            // Delete consecutive occurrences of c from prefix
            while (begin <= end && s.charAt(begin) == c) {
                begin++;
            }

            // Delete consecutive occurrences of c from suffix
            while (end > begin && s.charAt(end) == c) {
                end--;
            }

            return deleteSimilarEnds(s, begin, end);
        }
    }

}
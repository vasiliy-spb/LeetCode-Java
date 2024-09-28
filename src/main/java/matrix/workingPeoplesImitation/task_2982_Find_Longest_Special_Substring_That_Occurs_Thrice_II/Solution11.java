package matrix.workingPeoplesImitation.task_2982_Find_Longest_Special_Substring_That_Occurs_Thrice_II;

// from leetcode code sample (4)
// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/solutions/4482378/java-beats-100-full-explanation-easy-clean-code/
// good explanation
public class Solution11 {
    public int maximumLength(String s) {
        int n = s.length();
        //Base Case
        if (n <= 2) return 0;

        int freq[][] = new int[26][n + 1];
        char prev = s.charAt(0);
        int len = 1;
        freq[prev - 'a'][1] = 1;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                len++;
                freq[curr - 'a'][len] += 1;
            } else {
                freq[curr - 'a'][1] += 1;
                prev = curr;
                len = 1;
            }
        }

        int ans = -1;
        for (int i = 0; i < 26; i++) {
            int preSum = 0;
            for (int j = n; j >= 1; j--) {
                preSum += freq[i][j];
                if (preSum >= 3) {
                    ans = Math.max(ans, j);
                }
            }
        }
        return ans;
    }
}

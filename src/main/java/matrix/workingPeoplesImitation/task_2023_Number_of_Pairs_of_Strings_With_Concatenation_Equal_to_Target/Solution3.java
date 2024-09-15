package matrix.workingPeoplesImitation.task_2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target;

// from leetcode code sample (1)
public class Solution3 {
    public int numOfPairs(String[] nums, String target) {
        int n = target.length(), ans = 0;
        int[] forward = new int[n];
        int[] backward = new int[n];

        for (String s : nums) {
            int m = s.length(), diff = n - m;
            if (diff <= 0) continue;
            boolean isForwardSame = target.substring(0, m).equals(s);
            boolean isBackwardSame = target.substring(diff).equals(s);

            if (isForwardSame) ans += backward[m];
            if (isBackwardSame) ans += forward[diff - 1];
            if (isForwardSame) forward[m - 1]++;
            if (isBackwardSame) backward[diff]++;
        }

        return ans;
    }
}

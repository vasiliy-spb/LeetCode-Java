package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

// from leetcode solutions
// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/solutions/5928846/the-actual-optimal-solution-o-n-max-time-o-1-space/
public class Solution11 {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int n : nums) maxOr |= n;

        int numberOfBadSubsets = 0;
        for (int mask = maxOr; mask != 0; mask = (mask - 1) & maxOr) {
            int cnt = 0;
            for (int n : nums) if ((n & mask) == 0) cnt++;

            int sign = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
            numberOfBadSubsets += sign * ((1 << cnt) - 1);
        }

        return (1 << nums.length) - 1 - numberOfBadSubsets;
    }
}

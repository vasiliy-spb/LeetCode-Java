package matrix.workingPeoplesImitation.task_2401_Longest_Nice_Subarray;

// from leetcode code sample (1)
public class Solution4 {
    public int longestNiceSubarray(int[] nums) {
        int count = 0;
        int maxl = 1;
        int bit = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            bit = 0;
            for (int j = i; j < nums.length; j++) {
                if ((bit & nums[j]) == 0) {
                    bit |= nums[j];
                    count++;
                    maxl = Math.max(count, maxl);
                } else {
                    break;
                }
            }
        }
        return maxl;
    }
}

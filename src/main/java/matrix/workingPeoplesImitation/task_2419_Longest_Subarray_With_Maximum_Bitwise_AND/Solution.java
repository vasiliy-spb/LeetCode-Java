package matrix.workingPeoplesImitation.task_2419_Longest_Subarray_With_Maximum_Bitwise_AND;

import java.util.Arrays;

// my solution
public class Solution {
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int length = 0;
        int maxLength = 0;
        for (int num : nums) {
            if (num == max) {
                length++;
            } else {
                length = 0;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}

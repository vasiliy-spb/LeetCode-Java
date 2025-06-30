package matrix.workingPeoplesImitation.task_594_Longest_Harmonious_Subsequence;

import java.util.Arrays;

// my solution
public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int prevLength = 0;
        int currentLength = 0;
        int currentNum = nums[0];
        int maxLength = 0;
        for (int num : nums) {
            if (num == currentNum) {
                currentLength++;
                if (prevLength > 0) {
                    maxLength = Math.max(maxLength, currentLength + prevLength);
                }
                continue;
            }
            if (num - currentNum > 1) {
                prevLength = 0;
                currentLength = 1;
            } else {
                prevLength = currentLength;
                currentLength = 1;
                if (prevLength > 0) {
                    maxLength = Math.max(maxLength, currentLength + prevLength);
                }
            }
            currentNum = num;
        }
        return maxLength;
    }
}

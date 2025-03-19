package matrix.workingPeoplesImitation.task_2401_Longest_Nice_Subarray;

// my solution
public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            int minNiceIndex = findSmallestNiceIndex(nums, left, right);
            if (minNiceIndex == left) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                left = minNiceIndex;
            }
        }
        return maxLength;
    }

    private int findSmallestNiceIndex(int[] nums, int left, int right) {
        int minIndex = left;
        for (int i = right; i >= minIndex; i--) {
            for (int j = right - 1; j >= minIndex; j--) {
                if (i != j && (nums[i] & nums[j]) != 0) {
                    minIndex = Math.min(j + 1, right);
                    break;
                }
            }
        }
        return minIndex;
    }
}

package matrix.workingPeoplesImitation.task_2091_Removing_Minimum_and_Maximum_From_Array;

// my solution (fastest)
public class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int countDeletions = 0;
        if (minIndex < maxIndex) {
            countDeletions = minIndex + 1 + n - maxIndex;
            countDeletions = Math.min(countDeletions, maxIndex + 1);
            countDeletions = Math.min(countDeletions, n - minIndex);
        } else {
            countDeletions = maxIndex + 1 + n - minIndex;
            countDeletions = Math.min(countDeletions, minIndex + 1);
            countDeletions = Math.min(countDeletions, n - maxIndex);
        }
        return countDeletions;
    }
}

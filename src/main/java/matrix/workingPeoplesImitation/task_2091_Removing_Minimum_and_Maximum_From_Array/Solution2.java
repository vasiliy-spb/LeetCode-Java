package matrix.workingPeoplesImitation.task_2091_Removing_Minimum_and_Maximum_From_Array;

// my solution
public class Solution2 {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            min = nums[i] < nums[min] ? i : min;
            max = nums[i] > nums[max] ? i : max;
        }

        if (min > max) {
            min += max;
            max = min - max;
            min -= max;
        }

        int countDeletions = min + 1 + n - max;
        countDeletions = Math.min(countDeletions, max + 1);
        countDeletions = Math.min(countDeletions, n - min);
        return countDeletions;
    }
}

package matrix.workingPeoplesImitation.task_2874_Maximum_Value_of_an_Ordered_Triplet_II;

// from walkccc.me
public class Solution4 {
    // Same as 2873. Maximum Value of an Ordered Triplet I
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int maxDiff = 0; // max(nums[i] - nums[j])
        int maxNum = 0;  // max(nums[i])

        for (final int num : nums) {
            ans = Math.max(ans, (long) maxDiff * num); // num := nums[k]
            maxDiff = Math.max(maxDiff, maxNum - num); // num := nums[j]
            maxNum = Math.max(maxNum, num);            // num := nums[i]
        }

        return ans;
    }
}

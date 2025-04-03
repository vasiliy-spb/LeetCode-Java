package matrix.workingPeoplesImitation.task_2874_Maximum_Value_of_an_Ordered_Triplet_II;

// my solution
public class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int max = 0;
        int maxDiff = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long) maxDiff * num);
            maxDiff = Math.max(maxDiff, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}

package matrix.workingPeoplesImitation.task_1848_Minimum_Distance_to_the_Target_Element;

// from walkccc.me
public class Solution3 {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }

        return ans;
    }
}

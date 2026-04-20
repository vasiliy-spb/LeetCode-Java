package matrix.workingPeoplesImitation.task_1848_Minimum_Distance_to_the_Target_Element;

// from leetcode editorial (Approach: Simulation)
public class Solution2 {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}

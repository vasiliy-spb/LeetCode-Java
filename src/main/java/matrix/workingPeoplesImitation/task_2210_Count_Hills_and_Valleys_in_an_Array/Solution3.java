package matrix.workingPeoplesImitation.task_2210_Count_Hills_and_Valleys_in_an_Array;

// from walkccc.me
public class Solution3 {
    public int countHillValley(int[] nums) {
        int ans = 0;
        int left = nums[0];

        for (int i = 1; i + 1 < nums.length; ++i)
            if (left < nums[i] && nums[i] > nums[i + 1] || // the hill
                left > nums[i] && nums[i] < nums[i + 1]) { // the valley
                ++ans;
                left = nums[i];
            }

        return ans;
    }
}

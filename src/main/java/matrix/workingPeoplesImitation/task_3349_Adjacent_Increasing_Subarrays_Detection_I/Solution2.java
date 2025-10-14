package matrix.workingPeoplesImitation.task_3349_Adjacent_Increasing_Subarrays_Detection_I;

import java.util.List;

// from walkccc.me
public class Solution2 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int increasing = 1;
        int prevIncreasing = 0;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++increasing;
            } else {
                prevIncreasing = increasing;
                increasing = 1;
            }
            if (increasing / 2 >= k || Math.min(prevIncreasing, increasing) >= k) {
                return true;
            }
        }

        return false;
    }
}

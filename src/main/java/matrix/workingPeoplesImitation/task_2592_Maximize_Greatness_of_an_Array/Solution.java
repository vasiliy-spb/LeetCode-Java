package matrix.workingPeoplesImitation.task_2592_Maximize_Greatness_of_an_Array;

import java.util.Arrays;

// my solution
public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int ans = 0;
        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                ans++;
                left++;
            }
            right++;
        }
        return ans;
    }
}

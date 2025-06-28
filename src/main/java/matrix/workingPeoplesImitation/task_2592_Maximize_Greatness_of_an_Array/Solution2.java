package matrix.workingPeoplesImitation.task_2592_Maximize_Greatness_of_an_Array;

import java.util.Arrays;

// from leetcode code sample
public class Solution2 {
    public int maximizeGreatness(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int num : nums) {
            if (num > nums[count]) count++;
        }

        return count;
    }
}

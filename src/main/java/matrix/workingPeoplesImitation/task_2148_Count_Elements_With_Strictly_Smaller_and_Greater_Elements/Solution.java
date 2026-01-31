package matrix.workingPeoplesImitation.task_2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements;

import java.util.Arrays;

// my solution
public class Solution {
    public int countElements(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = nums.length - 2;
        int start = 1;
        while (start < nums.length && nums[start] == nums[start - 1]) {
            count--;
            start++;
        }
        int end = nums.length - 2;
        while (end >= 0 && nums[end] == nums[end + 1]) {
            count--;
            end--;
        }
        return Math.max(count, 0);
    }
}

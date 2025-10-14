package matrix.workingPeoplesImitation.task_3349_Adjacent_Increasing_Subarrays_Detection_I;

import java.util.List;

// my solution
public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k == 1) {
            return true;
        }
        int index = 0;
        while (index + k * 2 <= nums.size()) {
            if (isIncreasing(nums, index, k) && isIncreasing(nums, index + k, k)) {
                return true;
            }
            index++;
        }
        return false;
    }

    private static boolean isIncreasing(List<Integer> nums, int index, int length) {
        int end = index + length;
        int prev = nums.get(index++);
        while (index < end) {
            int current = nums.get(index++);
            if (current <= prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}

package matrix.workingPeoplesImitation.task_2210_Count_Hills_and_Valleys_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> differentNums = new ArrayList<>();
        differentNums.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                differentNums.add(nums[i]);
            }
        }

        int count = 0;
        for (int i = 1; i < differentNums.size() - 1; i++) {
            int current = differentNums.get(i);
            int prev = differentNums.get(i - 1);
            int next = differentNums.get(i + 1);
            if (current > prev && current > next) {
                count++;
            }
            if (current < prev && current < next) {
                count++;
            }
        }
        return count;
    }
}

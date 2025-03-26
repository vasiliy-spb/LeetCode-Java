package matrix.workingPeoplesImitation.task_2033_Minimum_Operations_to_Make_a_Uni_Value_Grid;

import java.util.Arrays;

// my solution
public class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] nums = new int[n * m];
        int index = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                nums[index++] = cell;
            }
        }
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int count = 0;
        for (int num : nums) {
            if ((target - num) % x != 0) {
                return -1;
            }
            count += Math.abs(target - num) / x;
        }
        return count;
    }
}

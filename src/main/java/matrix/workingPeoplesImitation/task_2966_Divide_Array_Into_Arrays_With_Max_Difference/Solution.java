package matrix.workingPeoplesImitation.task_2966_Divide_Array_Into_Arrays_With_Max_Difference;

import java.util.Arrays;

public class Solution {

    // my solution
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length / 3][3];
        for (int i = 1, j = 0; i < nums.length; i += 3, j++) {
            result[j][0] = nums[i - 1];
            result[j][1] = nums[i];
            result[j][2] = nums[i + 1];
            if (nums[i + 1] - nums[i - 1] > k) return new int[0][];
        }
        return result;
    }

    // from leetcode editorial
    public int[][] divideArray1(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }

}

package matrix.workingPeoplesImitation.task_2679_Sum_in_a_Matrix;

import java.util.Arrays;

public class Solution {
    public int matrixSum(int[][] nums) {
        for (int[] arr : nums) {
            Arrays.sort(arr);
        }
        int score = 0;
        for (int j = 0; j < nums[0].length; j++) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i][j]);
            }
            score += max;
        }
        return score;
    }
}

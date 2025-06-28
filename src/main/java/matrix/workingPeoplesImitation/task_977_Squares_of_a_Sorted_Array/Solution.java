package matrix.workingPeoplesImitation.task_977_Squares_of_a_Sorted_Array;

import java.util.Arrays;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (index >= 0) {
            int squareLeft = nums[left] * nums[left];
            int squareRight = nums[right] * nums[right];
            if (squareLeft > squareRight) {
                result[index] = squareLeft;
                left++;
            } else {
                result[index] = squareRight;
                right--;
            }
            index--;
        }
        return result;
    }
    public int[] sortedSquares1(int[] nums) {
        return Arrays.stream(nums).map(i -> i *= i).sorted().toArray();
    }
}

package matrix.workingPeoplesImitation.task_167_Two_Sum_II_Input_Array_Is_Sorted;

public class Solution {

    // my solution
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
            if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    // from walkccc.me
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (numbers[l] + numbers[r] != target)
            if (numbers[l] + numbers[r] < target)
                ++l;
            else
                --r;

        return new int[] {l + 1, r + 1};
    }
}

package matrix.workingPeoplesImitation.task_1508_Range_Sum_of_Sorted_Subarray_Sums;

import java.util.Arrays;

// my solution
public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = createArray(nums, n);
        Arrays.sort(arr);
        return calculateSum(left, right, arr);
    }

    private int[] createArray(int[] nums, int n) {
        int[] arr = new int[n * (n + 1) / 2];
        int index = 0;
        int startIndex = 0;
        while (index < arr.length) {
            for (int i = startIndex; i < nums.length; i++) {
                arr[index] = nums[i];
                if (i > startIndex) {
                    arr[index] += arr[index - 1];
                }
                index++;
            }
            startIndex++;
        }
        return arr;
    }

    private int calculateSum(int left, int right, int[] arr) {
        int modulo = (int) (1e9 + 7);
        int sum = 0;
        while (left <= right) {
            sum += arr[left - 1];
            sum %= modulo;
            left++;
        }
        return sum;
    }
}

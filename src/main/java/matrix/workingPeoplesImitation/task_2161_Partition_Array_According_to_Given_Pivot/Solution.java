package matrix.workingPeoplesImitation.task_2161_Partition_Array_According_to_Given_Pivot;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // my solution
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            }
            if (num > pivot) {
                greater.add(num);
            }
            if (num == pivot) {
                equal.add(num);
            }
        }
        int i = 0;
        for (int l : less) {
            nums[i++] = l;
        }
        for (int e : equal) {
            nums[i++] = e;
        }
        for (int g : greater) {
            nums[i++] = g;
        }
        return nums;
    }

    // from walkccc.me
    public int[] pivotArray2(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int i = 0; // ans' index

        for (final int num : nums)
            if (num < pivot)
                ans[i++] = num;

        for (final int num : nums)
            if (num == pivot)
                ans[i++] = num;

        for (final int num : nums)
            if (num > pivot)
                ans[i++] = num;

        return ans;
    }

    // from leetcode code sample
    public int[] pivotArray3(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0; // left pointer
        int right = nums.length - 1; // right pointer

        for (int i = 0; i < nums.length; i++) {
            // insert less than elements at start of result going right
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            // insert greater than elements from end of nums to end of result going left
            if (nums[nums.length - 1 - i] > pivot) {
                result[right--] = nums[nums.length - 1 - i];
            }
        }
        // fill all remaining spaces with the pivot number
        while (left <= right) {
            result[left++] = pivot;
            result[right--] = pivot;
        }
        return result;
    }

}

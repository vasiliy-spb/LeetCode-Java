package matrix.workingPeoplesImitation.task_268_Missing_Number;

import java.util.Arrays;

public class Solution {

    // my solution (sorting)
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    // my solution (sum)
    public int missingNumber1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return nums.length * (nums.length + 1) / 2 - sum;
    }

    // from walkccc.me (bit manipulation)
    public int missingNumber2(int[] nums) {
        int ans = nums.length;

        for (int i = 0; i < nums.length; ++i)
            ans ^= i ^ nums[i];

        return ans;
    }

    // from leetcode solutions (bit manipulation)
    // The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
    // In this solution, I apply XOR operation to both the index and value of the array.
    // In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
    public int missingNumber3(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    // from leetcode solutions (Binary Search)
    public int missingNumber4(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}

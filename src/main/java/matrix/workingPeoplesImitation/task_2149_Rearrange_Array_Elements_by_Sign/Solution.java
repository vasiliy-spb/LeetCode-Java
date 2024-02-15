package matrix.workingPeoplesImitation.task_2149_Rearrange_Array_Elements_by_Sign;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution (two pointers)
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                while (nums[l] < 0) {
                    l++;
                }
                result[i] = nums[l++];
            } else {
                while (nums[r] >= 0) {
                    r++;
                }
                result[i] = nums[r++];
            }
        }
        return result;
    }

    // my solution
    public int[] rearrangeArray1(int[] nums) {
        Queue<Integer> positiveQueue = new ArrayDeque<>();
        Queue<Integer> negativeQueue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) positiveQueue.offer(nums[i]);
            else negativeQueue.offer(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) nums[i] = positiveQueue.poll();
            else nums[i] = negativeQueue.poll();
        }
        return nums;
    }

    // from leetcode editorial
    public int[] rearrangeArray2(int[] nums) {
        int n = nums.length;

        // Initializing an answer array of size n
        int[] ans = new int[n];

        // Initializing two pointers to track even and
        // odd indices for positive and negative integers respectively
        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Placing the positive integer at the
                // desired index in ans and incrementing posIndex by 2
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                // Placing the negative integer at the
                // desired index in ans and incrementing negIndex by 2
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }

}

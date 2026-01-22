package matrix.workingPeoplesImitation.task_3507_Minimum_Pair_Removal_to_Sort_Array_I;

import java.util.Arrays;

// from leetcode editorial (Approach 2: Simulation + Array Simulation of Linked List)
public class Solution4 {
    public int minimumPairRemoval(int[] nums) {
        var n = nums.length;
        var next = new int[n];
        Arrays.setAll(next, i -> i + 1);
        next[n - 1] = -1;
        var count = 0;

        while (n - count > 1) {
            var curr = 0;
            var target = 0;
            var targetAdjSum = nums[target] + nums[next[target]];
            var isAscending = true;

            while (curr != -1 && next[curr] != -1) {
                if (nums[curr] > nums[next[curr]]) {
                    isAscending = false;
                }

                var currAdjSum = nums[curr] + nums[next[curr]];
                if (currAdjSum < targetAdjSum) {
                    target = curr;
                    targetAdjSum = currAdjSum;
                }
                curr = next[curr];
            }

            if (isAscending) {
                break;
            }

            count++;
            next[target] = next[next[target]];
            nums[target] = targetAdjSum;
        }

        return count;
    }
}

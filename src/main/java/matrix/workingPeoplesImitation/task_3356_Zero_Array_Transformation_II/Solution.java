package matrix.workingPeoplesImitation.task_3356_Zero_Array_Transformation_II;

import java.util.Arrays;

// my solution
public class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (Arrays.stream(nums).filter(n -> n > 0).count() == 0) {
            return 0;
        }
        int min = 0;
        int max = queries.length - 1;
        while (min < max) {
            int mid = (min + max) >> 1;
            if (isPossibleSetToZero(nums, queries, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return isPossibleSetToZero(nums, queries, max) ? max + 1 : -1;
    }

    private boolean isPossibleSetToZero(int[] nums, int[][] queries, int k) {
        int[] diff = new int[nums.length];
        for (int i = 0; i <= k; i++) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int val = query[2];
            diff[l] -= val;
            if (r + 1 < diff.length) {
                diff[r + 1] += val;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                diff[i] += diff[i - 1];
            }
            if (diff[i] + nums[i] > 0) {
                return false;
            }
        }
        return true;
    }
}

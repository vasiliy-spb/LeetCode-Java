package matrix.workingPeoplesImitation.task_2971_Find_Polygon_With_the_Largest_Perimeter;

import java.util.Arrays;

public class Solution {

    // my solution
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        long maxPerimeter = -1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                count++;
                if (count >= 3) {
                    if (prefixSum[i - 1] > nums[i]) {
                        maxPerimeter = Math.max(maxPerimeter, prefixSum[i - 1] + nums[i]);
                    }
                }
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            } else {
                if (count >= 3) maxPerimeter = Math.max(maxPerimeter, prefixSum[i - 1]);
                count = 1;
                prefixSum[i] = nums[i];
            }
        }
        return maxPerimeter;
    }
}



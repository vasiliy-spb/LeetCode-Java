package matrix.workingPeoplesImitation.task_1695_Maximum_Erasure_Value;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int currentSum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int num = nums[right];
            if (set.contains(num)) {
                while (nums[left] != num) {
                    currentSum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(num);
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

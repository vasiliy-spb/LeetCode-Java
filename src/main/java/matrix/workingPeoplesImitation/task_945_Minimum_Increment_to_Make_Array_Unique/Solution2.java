package matrix.workingPeoplesImitation.task_945_Minimum_Increment_to_Make_Array_Unique;

import java.util.Arrays;

// from leetcode editorial (Approach 1: Sorting)
public class Solution2 {
    public int minIncrementForUnique(int[] nums) {
        int minIncrements = 0;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            // Ensure each element is greater than its previous
            if (nums[i] <= nums[i - 1]) {
                // Add the required increment to minIncrements
                int increment = nums[i - 1] + 1 - nums[i];
                minIncrements += increment;

                // Set the element to be greater than its previous
                nums[i] = nums[i - 1] + 1;
            }
        }

        return minIncrements;
    }
}

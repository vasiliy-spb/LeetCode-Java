package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

// from leetcode editorial (Approach 3: Bit Manipulation)
public class Solution8 {
    public int countMaxOrSubsets(int[] nums) {
        // Calculate the maximum possible OR value
        int maxOrValue = 0;
        for (int num : nums) {
            maxOrValue |= num;
        }

        int totalSubsets = 1 << nums.length; // 2^n subsets
        int subsetsWithMaxOr = 0;

        // Iterate through all possible subsets
        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            int currentOrValue = 0;

            // Calculate OR value for the current subset
            for (int i = 0; i < nums.length; i++) {
                if (((subsetMask >> i) & 1) == 1) {
                    currentOrValue |= nums[i];
                }
            }

            // If current subset's OR equals maxOrValue, increment count
            if (currentOrValue == maxOrValue) {
                subsetsWithMaxOr++;
            }
        }

        return subsetsWithMaxOr;
    }
}
/*
Intuition

A subset of the array nums can be represented by a boolean array,
where each value indicates whether the corresponding element in nums is included.
For instance, if the 3rd index is true, it means the 3rd element is part of the subset.

With a maximum length of nums capped at 16, we can simplify this by using the binary representation of an integer,
where a set ith bit indicates the inclusion of the ith element of nums in the subset.
To understand this better, have a look at the below illustration:

[mask (Solution8).png]

    Note that the indexing direction in the mask is reversed to represent how we count positions: in an array, we count from left to right, but in a number, we count from right to left.

We'll then iterate over all possible subsets of nums by considering integers from 0 to 2n−1, each representing a unique subset.
For each subset, we calculate the OR value by performing a bitwise OR on elements corresponding to set bits in the integer.
If this OR value matches the maximum OR value (calculated beforehand), we increment a counter.
By the end, this counter gives the number of subsets that reach the maximum bitwise OR value.
 */

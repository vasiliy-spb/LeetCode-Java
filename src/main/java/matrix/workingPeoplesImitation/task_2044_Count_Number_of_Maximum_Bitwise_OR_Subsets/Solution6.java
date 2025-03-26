package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;


// from leetcode editorial (Approach 1: Recursion)
public class Solution6 {
    /*
    Overview

    The key insight here is that the maximum OR value will always be the result of OR-ing all the numbers in the array.
    Why? Because OR is an operation that only adds bits, it never removes them.
    So including more numbers can only increase (or keep the same) the OR value, never decrease it.

    For example, consider 3 numbers: 1 (001), 4 (100), and 2 (010).

    ORing the three numbers means we look at the bits in each position and combine them using the OR operation
    to get the resultant bit. Notice that the resultant bit will be 0 only when all the bits at that position are 0,
    otherwise, it will always be 1. This means that the worst-case scenario is that the bit remains the same,
    and in all other cases, the bit increases in value.
    */
    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;
        for (int num : nums) {
            maxOrValue |= num;
        }
        return countSubsets(nums, 0, 0, maxOrValue);
    }

    private int countSubsets(
            int[] nums,
            int index,
            int currentOr,
            int targetOr
    ) {
        // Base case: reached the end of the array
        if (index == nums.length) {
            return (currentOr == targetOr) ? 1 : 0;
        }

        // Don't include the current number
        int countWithout = countSubsets(nums, index + 1, currentOr, targetOr);

        // Include the current number
        int countWith = countSubsets(
                nums,
                index + 1,
                currentOr | nums[index],
                targetOr
        );

        // Return the sum of both cases
        return countWithout + countWith;
    }
}
/*
Intuition

To count all subsets of nums that yield the maximum OR value, we can generate all possible subsets recursively.
For each number, we choose either to include it in the subset or exclude it.

In the recursion, we first check if we've reached the end of the array.
If so, we compare the accumulated OR value with the precomputed maximum OR value.
If they match, we have a valid subset and return 1.

If we haven't reached the end, we proceed by making two recursive calls:
one excluding the current number and another including it.
The total count of valid subsets is the sum of these two results.

The main function initiates this recursive process from the start of the array,
and the final result gives the total count of subsets with the maximum OR value.
*/

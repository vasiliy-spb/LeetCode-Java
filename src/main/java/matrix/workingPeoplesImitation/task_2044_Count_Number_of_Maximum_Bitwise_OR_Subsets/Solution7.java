package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

// from leetcode editorial (Approach 2: Memoization)
public class Solution7 {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOrValue = 0;

        // Calculate the maximum OR value
        for (int num : nums) {
            maxOrValue |= num;
        }

        Integer[][] memo = new Integer[n][maxOrValue + 1];

        return countSubsetsRecursive(nums, 0, 0, maxOrValue, memo);
    }

    private int countSubsetsRecursive(
            int[] nums,
            int index,
            int currentOr,
            int targetOr,
            Integer[][] memo
    ) {
        // Base case: reached the end of the array
        if (index == nums.length) {
            return (currentOr == targetOr) ? 1 : 0;
        }

        // Check if the result for this state is already memoized
        if (memo[index][currentOr] != null) {
            return memo[index][currentOr];
        }

        // Don't include the current number
        int countWithout = countSubsetsRecursive(
                nums,
                index + 1,
                currentOr,
                targetOr,
                memo
        );

        // Include the current number
        int countWith = countSubsetsRecursive(
                nums,
                index + 1,
                currentOr | nums[index],
                targetOr,
                memo
        );

        // Memoize and return the result
        return memo[index][currentOr] = countWithout + countWith;
    }
}
/*
Intuition

Consider this example with nums = [3, 1, 2, 4]. During recursion, we might encounter two similar states:

    Subset 1: [3, 1] with index = 2
    Subset 2: [3] with index = 2

In both cases, the accumulated OR value and the current index are the same,
which is known as an overlapping sub-problem.

Memoization helps eliminate repeated calculations by storing the results of sub-problems the first time they're encountered.
Each recursive state can be uniquely identified by the OR value up to that point and the current array index.
To store these results, we use a 2D memo array.

At each recursion step, we first check if the current state exists in memo. If it does, we return the stored value.
Otherwise, we calculate the result and store it in memo for future reference.
 */
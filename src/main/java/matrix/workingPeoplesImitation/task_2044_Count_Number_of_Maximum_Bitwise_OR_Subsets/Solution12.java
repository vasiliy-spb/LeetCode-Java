package matrix.workingPeoplesImitation.task_2044_Count_Number_of_Maximum_Bitwise_OR_Subsets;

// from leetcode code sample (1)
public class Solution12 {
    int max = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int x : nums) {
            max |= x;
        }
        dfs(nums, 0, 0);
        return count;
    }

    void dfs(int[] nums, int index, int val) {
        if (val == max) {
            count += 1 << (nums.length - index);
            return;
        }

        for (int i = index; i < nums.length; ++i) {
            dfs(nums, i + 1, val | nums[i]);
        }
    }
}

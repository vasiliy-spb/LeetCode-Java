package matrix.workingPeoplesImitation.task_3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I;

// from leetcode editorial (Approach 2: Sliding Window)
public class Solution3 {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] == 0) {
                count++;
                nums[i - 2] = nums[i - 2] ^ 1;
                nums[i - 1] = nums[i - 1] ^ 1;
                nums[i] = nums[i] ^ 1;
            }
        }
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum == nums.length) return count;
        return -1;
    }
}

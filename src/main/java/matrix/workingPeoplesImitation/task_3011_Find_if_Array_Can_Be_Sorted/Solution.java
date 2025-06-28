package matrix.workingPeoplesImitation.task_3011_Find_if_Array_Can_Be_Sorted;

// my solution
public class Solution {
    public boolean canSortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j] && Integer.bitCount(nums[i]) != Integer.bitCount(nums[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}

package matrix.workingPeoplesImitation.task_3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct;

// from leetcode editorial (Approach 2: Reverse traversal)
public class Solution3 {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}

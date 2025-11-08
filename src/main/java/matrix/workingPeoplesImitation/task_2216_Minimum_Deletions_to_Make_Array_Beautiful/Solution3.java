package matrix.workingPeoplesImitation.task_2216_Minimum_Deletions_to_Make_Array_Beautiful;

// from leetcode code sample (1)
public class Solution3 {
    public int minDeletion(int[] nums) {
        int n = 0;
        int l = nums.length;
        int i = 0;
        while (i < l - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
                n++;
            } else {
                i += 2;
            }
        }
        if ((l - n) % 2 != 0) {
            n++;
        }
        return n;
    }
}

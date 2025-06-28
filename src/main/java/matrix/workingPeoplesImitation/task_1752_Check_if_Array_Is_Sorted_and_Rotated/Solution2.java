package matrix.workingPeoplesImitation.task_1752_Check_if_Array_Is_Sorted_and_Rotated;

// from walkccc.me
public class Solution2 {
    public boolean check(int[] nums) {
        final int n = nums.length;
        int rotates = 0;

        for (int i = 0; i < n; ++i)
            if (nums[i] > nums[(i + 1) % n] && ++rotates > 1)
                return false;

        return true;
    }
}

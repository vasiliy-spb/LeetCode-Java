package matrix.workingPeoplesImitation.task_1752_Check_if_Array_Is_Sorted_and_Rotated;

// from leetcode code sample
public class Solution3 {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}

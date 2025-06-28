package matrix.workingPeoplesImitation.task_1752_Check_if_Array_Is_Sorted_and_Rotated;

// my solution
public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int breakIndex = findBreakPoint(nums);
        int prev = nums[breakIndex];
        for (int i = 0; i < n; i++) {
            int current = nums[(breakIndex + i) % n];
            if (current < prev) {
                return false;
            }
            prev = current;
        }
        return true;
    }
    private int findBreakPoint(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] < prev) {
                return i;
            }
            prev = nums[i];
        }
        return 0;
    }
}

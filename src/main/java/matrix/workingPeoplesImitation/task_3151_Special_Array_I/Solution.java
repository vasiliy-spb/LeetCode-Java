package matrix.workingPeoplesImitation.task_3151_Special_Array_I;

// my solution
public class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean odd = nums[0] % 2 == 0;
        for (int n : nums) {
            if (!odd && (n % 2 == 0)) {
                return false;
            }
            if (odd && (n % 2 == 1)) {
                return false;
            }
            odd = !odd;
        }
        return true;
    }
}

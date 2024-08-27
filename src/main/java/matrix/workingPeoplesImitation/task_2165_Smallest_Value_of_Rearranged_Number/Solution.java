package matrix.workingPeoplesImitation.task_2165_Smallest_Value_of_Rearranged_Number;

// my solution
public class Solution {
    public long smallestNumber(long num) {
        int[] nums = new int[10];
        boolean positive = num >= 0;
        if (!positive) {
            num *= -1;
        }
        while (num > 0) {
            nums[(int) (num % 10)]++;
            num /= 10;
        }
        long ans = 0;
        if (positive) {
            for (int i = 1; i < 10; i++) {
                if (nums[i] > 0) {
                    ans = i;
                    nums[i]--;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (nums[i] > 0) {
                    ans *= 10;
                    ans += i;
                    nums[i]--;
                }
            }
        } else {
            for (int i = 9; i > 0; i--) {
                if (nums[i] > 0) {
                    ans = i;
                    nums[i]--;
                    break;
                }
            }
            for (int i = 9; i >= 0; i--) {
                while (nums[i] > 0) {
                    ans *= 10;
                    ans += i;
                    nums[i]--;
                }
            }
            ans = -ans;
        }
        return ans;
    }
}

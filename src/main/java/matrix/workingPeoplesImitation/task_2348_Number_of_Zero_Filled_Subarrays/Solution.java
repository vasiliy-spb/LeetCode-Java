package matrix.workingPeoplesImitation.task_2348_Number_of_Zero_Filled_Subarrays;

public class Solution {

    // my solution
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int length = 0;
        for (int num : nums) {
            if (num != 0) {
                count += (long) length * (length + 1) / 2;
                length = 0;
            } else length++;
        }
        count += (long) length * (length + 1) / 2;
        return count;
    }

    // from walkccc.me
    public long zeroFilledSubarray2(int[] nums) {
        long ans = 0;
        int indexBeforeZero = -1;

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == 0)
                ans += i - indexBeforeZero;
            else
                indexBeforeZero = i;

        return ans;
    }

    // from leetcode solutions
    //
    // We count consequitive zeros (i - j + 1).
    //For each zero, we add (i - j + 1) subarrays:
    //    0 -> +1
    //    00 -> +2 (_0 and 00)
    //    000 -> +3 (__0, _00, and 000)
    //    and so on...
    public long zeroFilledSubarray3(int[] nums) {
        long res = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (nums[i] != 0)
                j = i + 1;
            res += i - j + 1;
        }
        return res;
    }
}

package matrix.workingPeoplesImitation.task_2094_Finding_3_Digit_Even_Numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num > 99 && (num & 1) == 0) {
                        nums.add(num);
                    }
                }
            }
        }
        int[] ans = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            ans[i++] = num;
        }
        Arrays.sort(ans);
        return ans;
    }
}

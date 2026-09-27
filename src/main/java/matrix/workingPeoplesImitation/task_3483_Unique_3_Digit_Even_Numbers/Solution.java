package matrix.workingPeoplesImitation.task_3483_Unique_3_Digit_Even_Numbers;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int totalNumbers(int[] digits) {
        int[] digitsCount = new int[10];
        for (int i = 0; i < digits.length; i++) {
            digitsCount[digits[i]]++;
        }
        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            if (digitsCount[i] == 0) {
                continue;
            }
            int num = i * 100;
            digitsCount[i]--;
            for (int j = 0; j < 10; j++) {
                if (digitsCount[j] == 0) {
                    continue;
                }
                num += j * 10;
                digitsCount[j]--;
                for (int k = 0; k < 10; k += 2) {
                    if (digitsCount[k] == 0) {
                        continue;
                    }
                    num += k;
                    nums.add(num);
                    num -= k;
                }
                num -= j * 10;
                digitsCount[j]++;
            }
            digitsCount[i]++;
        }
        return nums.size();
    }
}

/*
206
230
236
260
302
306
320
326
360
362
602
620
632
630
*/

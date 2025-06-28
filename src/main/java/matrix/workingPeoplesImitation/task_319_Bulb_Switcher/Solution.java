package matrix.workingPeoplesImitation.task_319_Bulb_Switcher;

import java.util.Arrays;

public class Solution {

    // my solution
    public int bulbSwitch(int n) {
        int count = 0;
        if (n <= 10) {
            boolean[] bulb = new boolean[n];
            Arrays.fill(bulb, true);
            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j < n; j += i) {
                    bulb[j] = !bulb[j];
                }
            }
            for (boolean b : bulb) {
                if (b) {
                    count++;
                }
            }
        } else {
            int countZero = 2;
            int current = 0;
            while (current < n) {
                count++;
                current++;
                current += countZero;
                countZero += 2;
            }
        }
        return count;
    }

    // from leetcode editorial
    public int bulbSwitch2(int n) {
        return (int) Math.sqrt(n);
    }

    // from walkccc.me
    public int bulbSwitch3(int n) {
        // The k-th bulb can only be switched when k % i == 0.
        // So, we can rephrase the problem:
        // To find number of numbers <= n that have odd factors.
        // Obviously, only square numbers have odd factor(s).
        // e.g. n = 10, only 1, 4, and 9 are square numbers that <= 10
        return (int) Math.sqrt(n);
    }

}

// 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
// 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0
// 1 0 0 0 1 1 1 0 0 0 1 1 1 0 0 0
// 1 0 0 1 1 1 1 1 0 0 1 0 1 0 0 1
// 1 0 0 1 0 1 1 1 0 1 1 0 1 0 1 1
// 1 0 0 1 0 0 1 1 0 1 1 1 1 0 1 1
// 1 0 0 1 0 0 0 1 0 1 1 1 1 1 1 1
// 1 0 0 1 0 0 0 0 0 1 1 1 1 1 1 0
// 1 0 0 1 0 0 0 0 1 1 1 1 1 1 1 0
// 1 0 0 1 0 0 0 0 1 0 1 1 1 1 1 0
// 1 0 0 1 0 0 0 0 1 0 0 1 1 1 1 0
// 1 0 0 1 0 0 0 0 1 0 0 0 1 1 1 0
// 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1 0
// 1 0 0 1 0 0 0 0 1 0 0 0 0 0 1 0
// 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0 0
// 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0 1
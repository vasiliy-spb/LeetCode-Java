package matrix.workingPeoplesImitation.task_2048_Next_Greater_Numerically_Balanced_Number;

// my solution
public class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBalanced(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalanced(int num) {
        int[] digits = new int[10];
        while (num > 0) {
            digits[num % 10]++;
            num /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0 && digits[i] != i) {
                return false;
            }
        }
        return true;
    }
}

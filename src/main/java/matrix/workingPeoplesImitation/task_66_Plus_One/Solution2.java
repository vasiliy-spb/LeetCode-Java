package matrix.workingPeoplesImitation.task_66_Plus_One;

// from leetcode code sample (1)
public class Solution2 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry, return immediately
            }
            digits[i] = 0; // Set to 0 and carry over
        }

        // If all digits were 9, we need a new array with an extra digit
        int[] result = new int[n + 1];
        result[0] = 1; // The rest are 0 by default
        return result;
    }
}

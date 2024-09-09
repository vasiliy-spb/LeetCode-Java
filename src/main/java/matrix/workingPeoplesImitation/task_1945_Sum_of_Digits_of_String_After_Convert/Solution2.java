package matrix.workingPeoplesImitation.task_1945_Sum_of_Digits_of_String_After_Convert;

// from leetcode editorial (Approach 2: Direct Integer Operation)
public class Solution2 {
    public int getLucky(String s, int k) {
        // Convert the string to a number by summing digit values
        int currentNumber = 0;
        for (char ch : s.toCharArray()) {
            int position = ch - 'a' + 1;
            while (position > 0) {
                currentNumber += position % 10;
                position /= 10;
            }
        }

        // Apply digit sum transformations k-1 times
        for (int i = 1; i < k; ++i) {
            int digitSum = 0;
            while (currentNumber > 0) {
                digitSum += currentNumber % 10;
                currentNumber /= 10;
            }
            currentNumber = digitSum;
        }

        return currentNumber;
    }
}

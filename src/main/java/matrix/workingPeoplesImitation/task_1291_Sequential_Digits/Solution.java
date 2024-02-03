package matrix.workingPeoplesImitation.task_1291_Sequential_Digits;

import java.util.*;

public class Solution {

    // my solution
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();
        int arrayLength = 0;
        int temp = high;
        while (temp > 0) {
            arrayLength++;
            temp /= 10;
        }
        int[] numbers = new int[arrayLength];
        for (int i = numbers.length - 2; i >= 0; i--) {
            int num = numbers[i];
            for (int j = i; j < numbers.length; j++) {
                numbers[j] = num++;
            }
            while (numbers[numbers.length - 1] < 9) {
                for (int j = i; j < numbers.length; j++) {
                    numbers[j]++;
                }
                int currentNumber = numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    currentNumber *= 10;
                    currentNumber += numbers[j];
                }
                if (currentNumber > high) break;
                if (currentNumber >= low) answer.add(currentNumber);
            }
        }
        return answer;
    }

    // from walkccc.me
    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        while (!q.isEmpty()) {
            final int num = q.poll();
            if (num > high)
                return ans;
            if (low <= num && num <= high)
                ans.add(num);
            final int lastDigit = num % 10;
            if (lastDigit < 9)
                q.offer(num * 10 + lastDigit + 1);
        }

        return ans;
    }

    // from algo.monster
    public List<Integer> sequentialDigits3(int low, int high) {

        // Initialize the answer list to hold sequential digit numbers
        List<Integer> sequentialNumbers = new ArrayList<>();

        // Start generating numbers from each digit 1 through 8
        // A sequential digit number cannot start with 9 as it would not have a consecutive next digit
        for (int startDigit = 1; startDigit < 9; ++startDigit) {

            // Initialize the sequential number with the current starting digit
            int sequentialNum = startDigit;

            // Append the next digit to the sequential number, starting from startDigit + 1
            for (int nextDigit = startDigit + 1; nextDigit < 10; ++nextDigit) {

                // Append the next digit to the current sequential number
                sequentialNum = sequentialNum * 10 + nextDigit;

                // Check if the newly formed sequential number is within the range [low, high]
                if (sequentialNum >= low && sequentialNum <= high) {

                    // If it is within the range, add it to the answer list
                    sequentialNumbers.add(sequentialNum);
                }
            }
        }
        // Sort the list of sequential numbers
        Collections.sort(sequentialNumbers);

        // Return the list containing all valid sequential digit numbers in the range
        return sequentialNumbers;
    }

    // from leetcode solutions
    //
    // Approach 1
    // Iterate through starting digits from 1 to 9.
    // For each starting digit, build a sequential number by adding consecutive digits until reaching 9 or exceeding the high value.
    // Add valid sequential numbers to a vector (a).
    // Sort the vector.
    public List<Integer> sequentialDigits4(int low, int high) {
        List<Integer> a = new ArrayList<>();

        for (int i = 1; i <= 9; ++i) {
            int num = i;
            int nextDigit = i + 1;

            while (num <= high && nextDigit <= 9) {
                num = num * 10 + nextDigit;
                if (low <= num && num <= high) {
                    a.add(num);
                }
                ++nextDigit;
            }
        }

        a.sort(null);
        return a;
    }

    // from leetcode solutions
    //
    // Approach 2
    // digits from 1 to 9 are stored as characters in the string c = "123456789".
    // Two nested loops iterate over all possible substrings of c.
    // For each substring, convert it to an integer.
    // If the converted integer is within the given range, add it to the vector a.
    // Sort the vector.
    public List<Integer> sequentialDigits5(int low, int high) {
        String c = "123456789";
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    a.add(curr);
                }
            }
        }

        a.sort(null);
        return a;
    }

}

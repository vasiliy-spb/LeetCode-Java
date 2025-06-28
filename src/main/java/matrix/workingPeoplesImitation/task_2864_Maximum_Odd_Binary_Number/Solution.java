package matrix.workingPeoplesImitation.task_2864_Maximum_Odd_Binary_Number;

import java.util.Arrays;

public class Solution {

    // my solution
    public String maximumOddBinaryNumber(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (result.isEmpty() || result.charAt(result.length() - 1) == '0') result.append('1');
                else result.insert(0, '1');
            } else {
                if (result.isEmpty()) result.append('0');
                else result.insert(result.length() - 1, '0');
            }
        }
        return result.toString();
    }

    // from leetcode editorial (Approach 1: Greedy Bit Manipulation (Sorting and Swapping))
    public String maximumOddBinaryNumber2(String s) {
        char[] arr = s.toCharArray();
        int N = arr.length;

        Arrays.sort(arr);

        // Reverse order for the first N - 1 elements of the array
        // Because we want to keep a 1 at the last index
        // The last element of the array is index N - 1, and the second to last element is at N - 2
        int secondLast = N - 2;
        for (int i = 0; i < N / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[secondLast - i];
            arr[secondLast - i] = temp;
        }

        // Return result
        return new String(arr);
    }

    // from leetcode editorial (Approach 2: Greedy Bit Manipulation (Counting Ones))
    public String maximumOddBinaryNumber3(String s) {
        int N = s.length();

        // Find ones_cnt
        int ones_cnt = 0;
        for (int i = 0; i < N; i++) {
            ones_cnt += s.charAt(i) - '0';
        }

        // Use StringBuilder for fast concatenation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ones_cnt - 1; i++) {
            sb.append("1");
        }
        for (int i = 0; i < N - ones_cnt; i++) {
            sb.append("0");
        }
        sb.append("1");

        // Return result
        return sb.toString();
    }

    // from leetcode editorial (Approach 3: Greedy Bit Manipulation (One Pass with Two Pointers))
    public String maximumOddBinaryNumber4(String s) {
        // Create char array
        char[] arr = s.toCharArray();
        int N = arr.length;

        // Initialize two pointers
        int left = 0;
        int right = N - 1;

        while (left <= right) {

            // Increment left if equals 1
            if (arr[left] == '1') {
                left++;
            }
            // Decrement right if equals 0
            if (arr[right] == '0') {
                right--;
            }
            // Swap if neither pointer can be iterated
            if (left <= right && arr[left] == '0' && arr[right] == '1') {
                arr[left] = '1';
                arr[right] = '0';
            }
        }

        // Swap rightmost 1 bit to the end
        arr[left - 1] = '0';
        arr[N - 1] = '1';

        return new String(arr);
    }

}

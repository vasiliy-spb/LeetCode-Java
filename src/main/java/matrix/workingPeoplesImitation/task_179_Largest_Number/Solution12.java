package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.Arrays;

// from leetcode code sample (4)
public class Solution12 {
    // Helper function to get the number of digits in a number.
    public int numDigits(int n) {
        if (n == 0) return 1;
        return (int) Math.log10(n) + 1;
    }

    // Custom comparator to decide the order of numbers based on concatenation.
    private String[] regularize(int[] nums) {
        // Convert the array of integers into strings.
        String[] asStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrings[i] = String.valueOf(nums[i]);
        }
        // Sort based on the concatenation comparison.
        Arrays.sort(asStrings, (a, b) -> (b + a).compareTo(a + b));
        return asStrings;
    }

    // Function to create the largest number from the array of integers.
    public String largestNumber(int[] nums) {
        String[] sortedNums = regularize(nums);
        // If the largest number is '0', the result should be just '0'.
        if (sortedNums[0].equals("0")) {
            return "0";
        }
        // Build the largest number as a string.
        StringBuilder largestNum = new StringBuilder();
        for (String num : sortedNums) {
            largestNum.append(num);
        }
        return largestNum.toString();
    }
}

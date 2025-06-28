package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach 3: Merge Sort)
public class Solution6 {
    public String largestNumber(int[] nums) {
        // Sort the numbers using Merge Sort
        List<Integer> sortedNums = mergeSort(nums, 0, nums.length - 1);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : sortedNums) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private List<Integer> mergeSort(int[] nums, int left, int right) {
        // Base case: a single element is already sorted
        if (left >= right) return List.of(nums[left]);
        int mid = left + (right - left) / 2;
        // Recursively sort the left and right halves
        List<Integer> leftHalf = mergeSort(nums, left, mid);
        List<Integer> rightHalf = mergeSort(nums, mid + 1, right);
        // Merge the sorted halves
        return merge(leftHalf, rightHalf);
    }

    private List<Integer> merge(
            List<Integer> leftHalf,
            List<Integer> rightHalf
    ) {
        List<Integer> sortedNums = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;
        // Merge the two halves based on custom comparison
        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (compare(leftHalf.get(leftIndex), rightHalf.get(rightIndex))) {
                sortedNums.add(leftHalf.get(leftIndex++));
            } else {
                sortedNums.add(rightHalf.get(rightIndex++));
            }
        }
        // Append remaining elements from left half
        while (leftIndex < leftHalf.size()) sortedNums.add(
                leftHalf.get(leftIndex++)
        );
        // Append remaining elements from right half
        while (rightIndex < rightHalf.size()) sortedNums.add(
                rightHalf.get(rightIndex++)
        );
        return sortedNums;
    }

    private boolean compare(int firstNum, int secondNum) {
        // Compare concatenated strings to decide the order
        String s1 = String.valueOf(firstNum) + String.valueOf(secondNum);
        String s2 = String.valueOf(secondNum) + String.valueOf(firstNum);
        return s1.compareTo(s2) > 0;
    }
}

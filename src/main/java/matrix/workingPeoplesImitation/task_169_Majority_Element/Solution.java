package matrix.workingPeoplesImitation.task_169_Majority_Element;

import java.util.Arrays;

public class Solution {

    // my solution
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // from walkccc.me (explanation and comments from GPT)
    public int majorityElement2(int[] nums) {
        // Initialize the answer and count variables
        Integer ans = null; // Use Integer to represent the potential majority element
        int count = 0; // Initialize the count of the potential majority element as 0

        // Iterate through the array using a for-each loop
        for (final int num : nums) {
            // If the count becomes zero, update the potential majority element to the current element
            // and reset the count to 1, as we have found a new potential majority candidate
            if (count == 0)
                ans = num;

            // If the current element is the same as the potential majority element, increment the count
            // If the current element is different, decrement the count
            count += num == ans ? 1 : -1;
        }

        // The final answer is the potential majority element found during the iteration
        return ans;
    }

    // from GPT
    public int majorityElement3(int[] nums) {
        // Initialize the candidate and count variables
        int candidate = nums[0]; // Assume the first element as the candidate
        int count = 1; // Initialize the count of the candidate as 1

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the count becomes zero, update the candidate to the current element
            // and reset the count to 1, as we have found a new potential majority candidate
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            // If the current element is the same as the candidate, increment the count
            else if (nums[i] == candidate) {
                count++;
            }
            // If the current element is different from the candidate, decrement the count
            // as it represents a pair of different elements, cancelling each other out
            else {
                count--;
            }
        }

        // The final candidate is the majority element in the array
        return candidate;
    }
}

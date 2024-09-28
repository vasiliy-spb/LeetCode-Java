package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.Deque;
import java.util.LinkedList;

// from leetcode code sample (14)
public class Solution16 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // Initialize a flag to check if the current window is sorted and consecutive
        boolean isSortedAndConsecutive = true;

        // Preprocess the first window of size k
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i > 0 && nums[i] != nums[i - 1] + 1) {
                isSortedAndConsecutive = false;
            }
        }

        // Add the result for the first window
        result[0] = isSortedAndConsecutive ? nums[deque.peekFirst()] : -1;

        // Process the remaining windows
        for (int i = k; i < n; i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Add the new element to the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // Update the sorted and consecutive flag
            if (nums[i] != nums[i - 1] + 1) {
                isSortedAndConsecutive = false;
            }
            if (nums[i - k + 1] != nums[i - k] + 1) {
                isSortedAndConsecutive = true;
                for (int j = i - k + 2; j <= i; j++) {
                    if (nums[j] != nums[j - 1] + 1) {
                        isSortedAndConsecutive = false;
                        break;
                    }
                }
            }

            // Add the result for this window
            result[i - k + 1] = isSortedAndConsecutive ? nums[deque.peekFirst()] : -1;
        }

        return result;
    }
}

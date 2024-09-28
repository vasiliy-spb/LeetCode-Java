package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.Deque;
import java.util.LinkedList;

// from leetcode code sample (13)
public class Solution15 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        boolean isConsecutive = true;

        for (int i = 0; i < n; i++) {
            // Remove elements not in the current sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offerLast(i);

            // Check if the current element breaks the consecutive sequence
            if (i > 0 && nums[i] != nums[i - 1] + 1) {
                isConsecutive = false;
            }

            // Start filling the answer array when the first window is complete
            if (i >= k - 1) {
                // Reset the consecutive check for the new window
                if (i >= k && nums[i - k + 1] != nums[i - k] + 1) {
                    isConsecutive = true;
                    for (int j = i - k + 2; j <= i; j++) {
                        if (nums[j] != nums[j - 1] + 1) {
                            isConsecutive = false;
                            break;
                        }
                    }
                }

                if (isConsecutive) {
                    ans[i - k + 1] = nums[deque.peekFirst()];
                } else {
                    ans[i - k + 1] = -1;
                }
            }
        }

        return ans;
    }
}

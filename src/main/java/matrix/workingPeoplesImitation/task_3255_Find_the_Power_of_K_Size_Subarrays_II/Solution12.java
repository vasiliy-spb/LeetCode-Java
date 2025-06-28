package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.ArrayDeque;
import java.util.Deque;

// from leetcode code sample (10)
public class Solution12 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(nums[0]);
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[i - 1] + 1)
                q.clear();
            q.add(nums[i]);
        }
        result[0] = (q.size() >= k) ? nums[k - 1] : -1;
        for (int i = k; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1)
                q.clear();
            q.add(nums[i]);
            result[i - k + 1] = (q.size() >= k) ? q.getLast() : -1;
        }
        return result;
    }
}

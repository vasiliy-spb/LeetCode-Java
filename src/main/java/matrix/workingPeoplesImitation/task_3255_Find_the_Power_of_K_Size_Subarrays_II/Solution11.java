package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.ArrayList;
import java.util.Collections;

// from leetcode code sample (9)
public class Solution11 {
    public int[] resultsArray(int[] nums, int k) {
        ArrayList<Integer> prefix = new ArrayList<>(Collections.nCopies(nums.length, 0));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 + nums[i - 1]) prefix.set(i, 1 + prefix.get(i - 1));
            else prefix.set(i, 0);
        }
        int[] sol = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            if (prefix.get(i) >= k - 1) sol[i - k + 1] = nums[i];
            else sol[i - k + 1] = -1;
        }
        return sol;
    }
}

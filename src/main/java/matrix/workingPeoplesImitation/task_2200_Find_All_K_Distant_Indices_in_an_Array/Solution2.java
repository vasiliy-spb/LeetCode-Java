package matrix.workingPeoplesImitation.task_2200_Find_All_K_Distant_Indices_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach 1: Enumerate)
public class Solution2 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        // traverse number pairs
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    res.add(i);
                    break; // early termination to prevent duplicate addition
                }
            }
        }
        return res;
    }
}

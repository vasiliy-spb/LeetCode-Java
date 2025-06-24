package matrix.workingPeoplesImitation.task_2200_Find_All_K_Distant_Indices_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach 2: One-time Traversal)
public class Solution3 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0; // unjudged minimum index
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}

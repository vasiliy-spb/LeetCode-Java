package matrix.workingPeoplesImitation.task_2200_Find_All_K_Distant_Indices_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution4 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        final int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0, j = 0; i < n; ++i) {
            // the first index j s.t. nums[j] == key and j >= i - k
            while (j < n && (nums[j] != key || j < i - k))
                ++j;
            if (j == n)
                break;
            if (Math.abs(i - j) <= k)
                ans.add(i);
        }

        return ans;
    }
}

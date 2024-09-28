package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample (8)
public class Solution10 {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) return nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(nums[i] - nums[i - 1]);
        }

        int i = 0, j = 0;
        while (j < list.size()) {
            if (list.get(j) != 1) {
                i = j + 1;
            }
            if (j - i + 1 == k - 1) {
                ans[i] = nums[i + k - 1];
                i++;
            }
            j++;
        }

        return ans;
    }
}

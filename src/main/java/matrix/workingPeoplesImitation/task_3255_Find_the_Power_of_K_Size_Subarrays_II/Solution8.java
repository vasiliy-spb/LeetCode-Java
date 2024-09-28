package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// from leetcode code sample (6)
public class Solution8 {
    public int[] resultsArray(int[] nums, int k) {
        // find all map of consecutive elements
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);

        if (k == 1) return nums;
        for (int i = 1; i < n; ) {
            if (i < n && nums[i - 1] + 1 == nums[i]) {
                int temp = i - 1;
                while (i < n && nums[i - 1] + 1 == nums[i]) {
                    i++;
                }
                mp.put(temp, i - 1);
            } else i++;
        }
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            int from = m.getKey(), to = m.getValue();
            if (to - from + 1 >= k) {
                while (from <= to) {
                    int maxoIndex = from + k - 1;
                    if (maxoIndex <= to) {
                        ans[from++] = nums[maxoIndex];
                    } else break;
                }
            }
        }

        return ans;
    }
}

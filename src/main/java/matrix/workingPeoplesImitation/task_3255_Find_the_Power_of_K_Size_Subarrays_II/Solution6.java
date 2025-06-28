package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (4)
public class Solution6 {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        int resIndex = 0;
        int i = 1, j = 0, prevind = -1, n = nums.length;

        while (i < n) {
            while (i - j < k) {
                if (nums[i] != nums[i - 1] + 1) prevind = i;
                i++;
            }
            if (prevind > i - k) {
                res[resIndex++] = -1;
            } else {
                res[resIndex++] = nums[i - 1];
            }
            j++;
        }
        return res;
    }
}

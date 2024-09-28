package matrix.workingPeoplesImitation.task_3254_Find_the_Power_of_K_Size_Subarrays_I;

// from leetcode code sample (1)
public class Solution3 {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int beg = 0;
        int end = 0;
        while (end < nums.length) {
            while (beg < end && nums[beg] + 1 != nums[beg+1]) {
                beg++;
            }
            if (end > 0 && nums[end] - 1 != nums[end-1]) {
                beg = end;
            }
            if (end - k + 1 >= 0) {
                if (end - beg + 1 == k && nums[end] - nums[beg] + 1 == k) {
                    result[end - k + 1] = nums[end];
                    beg++;
                } else {
                    result[end - k + 1] = -1;
                }
            }
            end++;
        }
        return result;
    }
}

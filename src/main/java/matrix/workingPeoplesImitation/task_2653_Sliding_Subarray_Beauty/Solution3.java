package matrix.workingPeoplesImitation.task_2653_Sliding_Subarray_Beauty;

// from leetcode solutions (1)
// https://leetcode.com/problems/sliding-subarray-beauty/solutions/3445659/c-java-python3-simple-counting/
public class Solution3 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] counter = new int[50], ans = new int[nums.length - k + 1];;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) counter[nums[i] + 50]++;
            if (i - k >= 0 && nums[i - k] < 0) counter[nums[i - k] + 50]--;
            if (i - k + 1 < 0) continue;
            for (int j = 0, count = 0; j < 50; j++) {
                count += counter[j];
                if (count >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
        }
        return ans;
    }

    // Java but more concise:
    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        int[] counter = new int[50], ans = new int[nums.length - k + 1];;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) counter[nums[i] + 50]++;
            if (i - k >= 0 && nums[i - k] < 0) counter[nums[i - k] + 50]--;
            for (int j = 0, count = 0; j < 50 && count < x && i >= k - 1; j++)
                if ((count += counter[j]) >= x)
                    ans[i - k + 1] = j - 50;
        }
        return ans;
    }
}

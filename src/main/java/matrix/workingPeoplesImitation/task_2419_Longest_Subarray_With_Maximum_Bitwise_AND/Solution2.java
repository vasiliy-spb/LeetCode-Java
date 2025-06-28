package matrix.workingPeoplesImitation.task_2419_Longest_Subarray_With_Maximum_Bitwise_AND;

// from leetcode editorial (Approach: Longest consecutive sequence of the maximum value)
public class Solution2 {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, ans = 0, currentStreak = 0;

        for (int num : nums) {
            if (maxVal < num) {
                maxVal = num;
                ans = currentStreak = 0;
            }

            if (maxVal == num) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }

            ans = Math.max(ans, currentStreak);
        }
        return ans;
    }
}

package matrix.workingPeoplesImitation.task_1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

public class Solution {

    // my solution
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int zerosCount = 0;
        while(right < nums.length) {

            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > 1) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1 - zerosCount);
            right++;
        }
        return maxLength == nums.length ? maxLength - 1 : maxLength;
    }

    // from leetcode editorial
    public int longestSubarray2(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);

            // Shrink the window until the zero counts come under the limit.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }

    // from walkccc.me (Approach 1: Standard Sliding Window)
    public int longestSubarray3(int[] nums) {
        int ans = 0;
        int count0 = 0;

        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == 0)
                ++count0;
            while (count0 == 2)
                if (nums[l++] == 0)
                    --count0;
            ans = Math.max(ans, r - l);
        }

        return ans;
    }

    // from walkccc.me (Approach 2: Non-shrinking Sliding Window)
    public int longestSubarray4(int[] nums) {
        int l = 0;
        int count0 = 0;

        for (final int num : nums) {
            if (num == 0)
                ++count0;
            if (count0 > 1 && nums[l++] == 0)
                --count0;
        }

        return nums.length - l - 1;
    }
}

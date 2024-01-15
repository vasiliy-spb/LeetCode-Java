package matrix.workingPeoplesImitation.task_1004_Max_Consecutive_Ones_III;

public class Solution {

    // my solution
    public int longestOnes(int[] nums, int k) {
        int flip = k;
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentLength++;
            } else {
                if (flip > 0) {
                    flip--;
                    currentLength++;
                } else {
                    while (nums[i - currentLength] == 1) {
                        currentLength--;
                    }
                    if (currentLength > 0) {
                        currentLength--;
                        i--;
                    }
                    if (flip + 1 <= k) flip++;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    // from walkccc.me
    public int longestOnes2(int[] nums, int k) {
        int ans = 0;

        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == 0)
                --k;
            while (k < 0)
                if (nums[l++] == 0)
                    ++k;
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    // from GPT
    public static int longestOnes3(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxConsecutiveOnes = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
            right++;
        }

        return maxConsecutiveOnes;  // 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0
    }

}

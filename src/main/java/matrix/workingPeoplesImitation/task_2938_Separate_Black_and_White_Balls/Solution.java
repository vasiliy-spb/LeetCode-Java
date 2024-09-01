package matrix.workingPeoplesImitation.task_2938_Separate_Black_and_White_Balls;

// my solution
public class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        if (n == 1) return 0;
        long ans = 0;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < n) {
            if (arr[right] == '0') {
                ans += right - left;
                left++;
            }
            right++;
        }
        return ans;
    }
}

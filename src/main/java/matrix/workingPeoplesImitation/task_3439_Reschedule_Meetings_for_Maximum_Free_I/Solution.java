package matrix.workingPeoplesImitation.task_3439_Reschedule_Meetings_for_Maximum_Free_I;

// my solution
public class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int maxLength = startTime[0];
        int length = startTime[0];
        int left = 0;
        int right = 0;
        while (right < n) {
            if (right - left >= k) {
                if (left == 0) {
                    length -= startTime[left];
                } else {
                    length -= startTime[left] - endTime[left - 1];
                }
                left++;
            }
            int lastEnd = endTime[right++];
            if (right == n) {
                length += eventTime - endTime[n - 1];
            } else {
                length += startTime[right] - lastEnd;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}

package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// my solution
public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] prefixTrue = new int[n + 1];
        int[] prefixFalse = new int[n + 1];
        for (int i = 0; i < answerKey.length(); i++) {
            char key = answerKey.charAt(i);
            prefixTrue[i + 1] = prefixTrue[i] + (key == 'T' ? 1 : 0);
            prefixFalse[i + 1] = prefixFalse[i] + (key == 'F' ? 1 : 0);
        }
        int length = calculateMaxLength(k, n, prefixTrue);
        length = Math.max(length, calculateMaxLength(k, n, prefixFalse));
        return length;
    }

    private static int calculateMaxLength(int k, int n, int[] prefixTrue) {
        int left = 0;
        int right = 0;
        int length = 0;
        while (right <= n) {
            if (prefixTrue[right] - prefixTrue[left] <= k) {
                length = Math.max(length, right - left);
                right++;
            } else {
                left++;
            }
        }
        return length;
    }
}

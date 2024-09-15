package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (2)
public class Solution4 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] count = new int[26];
        char[] arr = answerKey.toCharArray();
        int left = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            count[c - 'A']++;
            int min = Math.min(count['T' - 'A'], count['F' - 'A']);
            if (min <= k) {
                max++;
            } else {
                count[arr[left] - 'A']--;
                left++;
            }
        }
        return max;
    }
}

package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (1)
public class Solution3 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int maxF = 0, result = 0;
        int count[] = new int[128];

        for (int i = 0; i < chars.length; i++) {
            maxF = Math.max(maxF, ++count[chars[i]]);
            if (result - maxF < k) {
                result++;
            } else {
                count[chars[i - result]]--;
            }
        }

        return result;
    }
}

package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (5)
public class Solution7 {
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int left = 0, right = 0;
        int max = 0;

        int T = 0, F = 0; // to keep count of True and False

        while (right < answerKey.length()) {

            char c = answerKey.charAt(right);

            if (c == 'T') T++;
            else F++;

            // We will flip the minimum of T/F
            // Hence when mini when Math.min(T,F) > k , we start reducing the window size till it's valid again
            while (Math.min(T, F) > k) {
                char l = answerKey.charAt(left);
                if (l == 'T') T--;
                else F--;
                left++;
            }

            max = Math.max(max, (right - left) + 1);

            right++;
        }

        return max;
    }
}

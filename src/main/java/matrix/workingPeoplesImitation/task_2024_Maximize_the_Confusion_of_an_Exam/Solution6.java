package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (4)
public class Solution6 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int i = 0;
        int j = 0;
        int countT = 0;
        int countF = 0;
        int result = 0;

        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == 'T') {
                countT++;
            } else {
                countF++;
            }

            while (countF > k && countT > k) {
                if (answerKey.charAt(i) == 'T')
                    countT--;
                else
                    countF--;
                i++;
            }
            result = Math.max(result, (j - i) + 1);
            j++;

        }

        return result;

    }
}

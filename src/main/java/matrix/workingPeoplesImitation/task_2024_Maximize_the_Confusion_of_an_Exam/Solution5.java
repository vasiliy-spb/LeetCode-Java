package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

// from leetcode code sample (3)
public class Solution5 {
    public int maxConsecutiveAnswers(String s, int k) {
        int maxf = 0, i = 0, n = s.length(), count[] = new int[26];
        for (int j = 0; j < n; ++j) {
            maxf = Math.max(maxf, ++count[s.charAt(j) - 'A']);
            if (j - i + 1 > maxf + k)
                --count[s.charAt(i++) - 'A'];
        }
        return n - i;
    }
}

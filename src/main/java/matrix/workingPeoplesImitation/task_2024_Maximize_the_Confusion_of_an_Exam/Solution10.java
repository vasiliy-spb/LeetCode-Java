package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

import java.util.LinkedList;

// from leetcode code solutions (https://leetcode.com/problems/maximize-the-confusion-of-an-exam/solutions/1501080/java-solution-explanation/)
public class Solution10 {
    /*

    We have 2 cases:

        When T sequence is the longest
        When F sequence is the longest

    So we compare both cases and return max

    Flipper function
    Let's observe 1st case as an example

        If we encounter T, then we increment counter
        If we encounter F, then we decrement k counter. It means that we flipped F->T and then increment counter. We save index.
        If k==0 we take first encountered F and take away values befpre it

     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(flipper(answerKey, k, 'F'), flipper(answerKey, k, 'T'));
    }

    public int flipper(String answerKey, int k, char countLetter) {
        int max = 0;
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < answerKey.length(); i++) {
            char letter = answerKey.charAt(i);
            if (letter == countLetter) count++;
            else if (k > 0) {
                queue.add(i);
                k--;
                count++;
            } else {
                queue.add(i);
                max = Math.max(count, max);
                Integer firstEncountered = queue.removeFirst();
                count = i - firstEncountered;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}

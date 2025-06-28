package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

import java.util.LinkedList;
import java.util.Queue;

// from leetcode code solutions (https://leetcode.com/problems/maximize-the-confusion-of-an-exam/solutions/4593775/maximize-the-confusion-of-an-exam-simplified-java/)
public class Solution11 {
    /*
    Hints

        Try finding the maximum length of the sequence that can be achieved.
        A window of length k can be formed by either T or F. Generate a method to evaluate the possiblity of window of size k.
        Can you optimise it further?
        Check the values of window sizes available. Got any ideas?

    Intuition

        The window sizes are sorted. So, we will use Binary Search as Range Detection for window sizes.
        The concurrent sequence of size k can be formed of either all T or all F.
        Develop method to find the window which has concurrent sequence of size k using Sliding Window.

     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return LengthBinaryOptimisation(answerKey, k);  // Function Call...
    }

    public int LengthBinaryOptimisation(String answerKey, int swaps) {
        int min = 1, max = answerKey.length(), windowSize = 0;  // Bounding Variables...
        while (min <= max) {
            int middle = (min + max) / 2;   // Evaluating window width...
            if (SequenceObtained(answerKey, swaps, 'F', middle) || SequenceObtained(answerKey, swaps, 'T', middle)) {    // If any consecutive sequences of 'T' or 'F' can be formed...
                windowSize = middle;
                min = middle + 1;    // Increase window width...
            } else max = middle - 1;     // Otherwise decrase window width...
        }
        return windowSize;      // Return the maximum window size possible...
    }

    public boolean SequenceObtained(String answerKey, int swaps, char seqChar, int window) {
        Queue<Character> queue = new LinkedList<Character>();   // Queue for Sliding Window...
        int count = 0;  // counting the variables that need to be swapped...
        for (int i = 0; i < window; i++) {
            queue.add(answerKey.charAt(i));     // Intialising the Sliding Window...
            if (answerKey.charAt(i) == seqChar) count++;
        }
        if (count <= swaps) return true;    // If Sliding Window is consecutive...
        for (int i = window; i < answerKey.length(); i++) {
            char popped = queue.poll();     // Shifting the Sliding Window right...
            if (popped == seqChar) count--;
            queue.add(answerKey.charAt(i));
            if (answerKey.charAt(i) == seqChar) count++;    // If consecutive sequence possible...
            if (count <= swaps) return true;    // If consecutive window found...
        }
        return false;
    }
}

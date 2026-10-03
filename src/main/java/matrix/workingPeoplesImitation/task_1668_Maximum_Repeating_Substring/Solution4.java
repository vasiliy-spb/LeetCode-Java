package matrix.workingPeoplesImitation.task_1668_Maximum_Repeating_Substring;

// my solution (accepted)
public class Solution4 {
    public int maxRepeating(String sequence, String word) {
        int k = sequence.length() / word.length();
        while (!sequence.contains(word.repeat(k))) {
            k--;
        }
        return k;
    }
}

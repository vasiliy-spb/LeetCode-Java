package matrix.workingPeoplesImitation.task_657_Robot_Return_to_Origin;

// from leetcode code sample (1)
public class Solution2 {
    public static boolean judgeCircle(String moves) {
        int[] freq = new int[26];
        char[] move = moves.toCharArray();
        if (move.length % 2 != 0) {
            return false;
        }
        for (char ch : move) {
            freq[ch - 'A']++;
        }
        return freq['U' - 'A'] == freq['D' - 'A'] && freq['L' - 'A'] == freq['R' - 'A'];
    }
}

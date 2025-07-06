package matrix.workingPeoplesImitation.task_848_Shifting_Letters;

// from leetcode code sample (1)
public class Solution4 {
    public String shiftingLetters(String s, int[] shifts) {
        long max = 0L;
        char[] check = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            max += shifts[i];
            check[i] = (char) ('a' + (check[i] - 'a' + max) % 26);

        }
        return new String(check);
    }
}

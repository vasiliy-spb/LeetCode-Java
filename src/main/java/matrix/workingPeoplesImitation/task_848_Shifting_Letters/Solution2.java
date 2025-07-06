package matrix.workingPeoplesImitation.task_848_Shifting_Letters;

// my solution 2
public class Solution2 {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        for (int i = shifts.length - 1; i >= 0; i--) {
            if (i < shifts.length - 1) {
                shifts[i] += shifts[i + 1];
                shifts[i] %= 26;
            }
            ans.append((char) (((s.charAt(i) - 'a' + shifts[i]) % 26) + 'a'));
        }
        return ans.reverse().toString();
    }
}

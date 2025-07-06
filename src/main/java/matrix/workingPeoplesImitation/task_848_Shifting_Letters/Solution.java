package matrix.workingPeoplesImitation.task_848_Shifting_Letters;

// my solution
public class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append((char) (((s.charAt(i) - 'a' + shifts[i]) % 26) + 'a'));
        }
        return ans.toString();
    }
}

package matrix.workingPeoplesImitation.task_2381_Shifting_Letters_II;

// my solution
public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] sumShifts = computeSumShifts(shifts, n);

        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            chars[i] = (char) (((((chars[i] - 'a' + sumShifts[i]) % 26) + 26) % 26) + 'a');
        }
        return new String(chars);
    }

    private static int[] computeSumShifts(int[][] shifts, int n) {
        int[] sumShifts = new int[n];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 0 ? -1 : 1;
            sumShifts[start] += direction;
            if (end + 1 < n) {
                sumShifts[end + 1] -= direction;
            }
        }
        for (int i = 1; i < n; i++) {
            sumShifts[i] += sumShifts[i - 1];
        }
        return sumShifts;
    }
}

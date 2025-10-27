package matrix.workingPeoplesImitation.task_2125_Number_of_Laser_Beams_in_a_Bank;

// my solution
public class Solution {
    public int numberOfBeams(String[] bank) {
        int count = -1;
        int prev = 1;
        for (String line : bank) {
            int current = 0;
            for (char ch : line.toCharArray()) {
                current += Character.getNumericValue(ch);
            }
            if (current == 0) {
                continue;
            }
            if (count < 0) {
                count = 0;
            } else {
                count += prev * current;
            }
            prev = current;
        }
        return Math.max(count, 0);
    }
}

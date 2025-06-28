package matrix.workingPeoplesImitation.task_1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box;

// my solution
public class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    ans[i] += Math.abs(j - i);
                }
            }
        }
        return ans;
    }
}

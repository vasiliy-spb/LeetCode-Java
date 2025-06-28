package matrix.workingPeoplesImitation.task_1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;

public class Solution {

    // my solution
    public int minPartitions(String n) {
        int max = 0;
        for (char ch : n.toCharArray()) {
            max = Math.max(max, ch - '0');
        }
        return max;
    }

    // from walkccc.me
    public int minPartitions2(String n) {
        return Character.getNumericValue(n.chars().max().getAsInt());
    }

}

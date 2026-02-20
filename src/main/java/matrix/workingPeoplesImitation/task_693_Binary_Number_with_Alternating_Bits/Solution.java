package matrix.workingPeoplesImitation.task_693_Binary_Number_with_Alternating_Bits;

// my solution
public class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        return !(binary.contains("00") || binary.contains("11"));
    }
}

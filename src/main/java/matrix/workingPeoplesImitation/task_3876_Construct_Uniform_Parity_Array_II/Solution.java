package matrix.workingPeoplesImitation.task_3876_Construct_Uniform_Parity_Array_II;

// my solution
public class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean allEven = true;
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            allEven &= (num & 1) == 0;
            if (num < min) {
                min = num;
            }
        }
        return (min & 1) == 1 || allEven;
    }
}

package matrix.workingPeoplesImitation.task_961_N_Repeated_Element_in_Size_2N_Array;

// from leetcode editorial (Approach 2: Compare)
public class Solution3 {
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k) {
            for (int i = 0; i < A.length - k; ++i) {
                if (A[i] == A[i + k]) {
                    return A[i];
                }
            }
        }

        throw null;
    }
}

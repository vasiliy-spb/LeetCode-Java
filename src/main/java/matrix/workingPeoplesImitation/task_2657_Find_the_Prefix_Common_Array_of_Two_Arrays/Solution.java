package matrix.workingPeoplesImitation.task_2657_Find_the_Prefix_Common_Array_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i > 0) {
                ans[i] = ans[i - 1];
            }
            if (aSet.contains(B[i])) {
                ans[i]++;
            }
            aSet.add(A[i]);
            bSet.add(B[i]);
            if (bSet.contains(A[i])) {
                ans[i]++;
            }
        }
        return ans;
    }
}

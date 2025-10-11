package matrix.workingPeoplesImitation.task_3159_Find_Occurrences_of_an_Element_in_an_Array;

import java.util.Arrays;

// my solution
public class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int m = (int) Arrays.stream(nums).filter(num -> num == x).count();
        int[] xIndex = new int[m];
        for (int i = 0, xi = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                xIndex[xi++] = i;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > xIndex.length) {
                ans[i] = -1;
            } else {
                ans[i] = xIndex[queries[i] - 1];
            }
        }
        return ans;
    }
}

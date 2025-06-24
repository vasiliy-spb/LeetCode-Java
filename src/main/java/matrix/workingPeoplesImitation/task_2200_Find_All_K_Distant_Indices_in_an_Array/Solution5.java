package matrix.workingPeoplesImitation.task_2200_Find_All_K_Distant_Indices_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (1)
public class Solution5 {
    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (nums[j] != key) {
                j++;
            } else if (i < j - k) {
                i++;
            } else if (i <= j + k) {
                res.add(i++);
            } else {
                j++;
            }
        }

        return res;
    }
}

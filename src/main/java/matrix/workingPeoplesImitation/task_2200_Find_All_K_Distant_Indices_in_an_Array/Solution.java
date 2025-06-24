package matrix.workingPeoplesImitation.task_2200_Find_All_K_Distant_Indices_in_an_Array;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// my solution
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = 0; j < nums.length; j++) {
                    if (Math.abs(i - j) <= k) {
                        set.add(j);
                    }
                }
            }
        }
        return set.stream().toList();
    }
}

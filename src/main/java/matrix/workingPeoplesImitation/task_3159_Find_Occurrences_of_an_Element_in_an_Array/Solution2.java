package matrix.workingPeoplesImitation.task_3159_Find_Occurrences_of_an_Element_in_an_Array;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indices = getIndices(nums, x);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = queries[i] <= indices.size() ? indices.get(queries[i] - 1) : -1;
        }

        return ans;
    }

    private List<Integer> getIndices(int[] nums, int x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }
        return indices;
    }
}

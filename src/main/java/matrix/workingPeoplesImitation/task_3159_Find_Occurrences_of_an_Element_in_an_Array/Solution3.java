package matrix.workingPeoplesImitation.task_3159_Find_Occurrences_of_an_Element_in_an_Array;

// from leetcode code sample (1)
public class Solution3 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int occurrences = 0;
        int[] indices = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices[occurrences++] = i;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > occurrences) {
                ans[i] = -1;
            } else {
                ans[i] = indices[queries[i] - 1];
            }
        }

        return ans;
    }
}

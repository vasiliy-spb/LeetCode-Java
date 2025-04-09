package matrix.workingPeoplesImitation.task_3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K;

// from leetcode code sample (1)
public class Solution4 {
    public int minOperations(int[] nums, int k) {
        boolean[] has = new boolean[101];

        for (int num : nums) {
            has[num] = true;
        }
        int cnt = 0;
        for (int i = 0; i < has.length; i++) {
            if (!has[i]) continue;

            if (has[i] && i < k)
                return -1;
            else if (has[i] && i > k)
                cnt++;
        }
        return cnt;
    }
}

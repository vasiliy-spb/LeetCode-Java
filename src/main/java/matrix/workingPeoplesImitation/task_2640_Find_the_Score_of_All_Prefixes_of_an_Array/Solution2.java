package matrix.workingPeoplesImitation.task_2640_Find_the_Score_of_All_Prefixes_of_an_Array;

// from walkccc.me
public class Solution2 {
    public long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length];
        long prefix = 0;
        int mx = 0;

        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            prefix += nums[i] + mx;
            ans[i] = prefix;
        }

        return ans;
    }
}

package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

// from leetcode code sample (3)
public class Solution5 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        int count = 0;

        for(int i=0;i<n;i++) {
            if(i == 0 || nums[i] == nums[i-1]+1)
                count++;
            else count = 1;

            if(i+1 >= k) {
                if(count >= k)
                    res[i-k+1] = nums[i];
                else
                    res[i-k+1] = -1;
            }
        }



        return res;
    }
}

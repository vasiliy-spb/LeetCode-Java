package matrix.workingPeoplesImitation.task_3254_Find_the_Power_of_K_Size_Subarrays_I;

// from leetcode code sample (2)
public class Solution4 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i=0;i<n-k+1;i++) {
            int j = i;
            for(j=i;j<i+k-1;j++) {
                if(nums[j+1] != nums[j]+1)
                    break;
            }

            if(j != i+k-1) res[i] = -1;
            else res[i] = nums[i+k-1];
        }

        return res;
    }
}

package matrix.workingPeoplesImitation.task_1695_Maximum_Erasure_Value;

// from leetcode code sample (1)
public class Solution3 {
    // public int maximumUniqueSubarray(int[] nums) {
    //     int L = 0;
    //     int R = 0;
    //     int sum = 0, max = 0;
    //     HashSet<Integer> set = new HashSet<>();
    //     while(R < nums.length) {
    //         if(set.contains(nums[R])) {
    //             while(L < R && set.contains(nums[R])) {
    //                  set.remove(nums[L]);
    //                 sum -= nums[L];
    //                 L++;
    //             }
    //         }
    //         if(!set.contains(nums[R])) {
    //             set.add(nums[R]);
    //             sum += nums[R];
    //         }

    //         max = Math.max(sum, max);
    //         R++;
    //     }
    //     return max;
    // }

    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, r = 0, maxsum = 0, n = nums.length, sum = 0;
        int[] hash = new int[10001];

        for (int i = 0; i < 10001; i++) {
            hash[i] = -1;
        }

        while (r < n) {
            if (hash[nums[r]] != -1 && hash[nums[r]] >= l) {
                while (l <= hash[nums[r]]) {
                    sum -= nums[l];
                    l++;
                }
            }

            sum += nums[r];
            maxsum = Math.max(maxsum, sum);
            hash[nums[r]] = r;
            r++;
        }

        return maxsum;
    }
}

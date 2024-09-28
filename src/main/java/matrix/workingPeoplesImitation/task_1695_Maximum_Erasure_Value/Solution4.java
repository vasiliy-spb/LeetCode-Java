package matrix.workingPeoplesImitation.task_1695_Maximum_Erasure_Value;

// from leetcode code sample (2)
public class Solution4 {
    public int maximumUniqueSubarray(int[] nums) {
        final int n = nums.length;
        boolean[] isPresent = new boolean[10001];
        int total = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int curr = nums[right];
            while(isPresent[curr]){
                int prev = nums[left++];
                isPresent[prev] = false;
                total -= prev;
            }
            isPresent[curr] = true;
            total += curr;
            max = Math.max(max, total);
        }
        return max;
    }
}

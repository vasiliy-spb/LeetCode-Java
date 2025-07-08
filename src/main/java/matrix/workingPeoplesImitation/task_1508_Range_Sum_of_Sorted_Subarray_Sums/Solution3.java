package matrix.workingPeoplesImitation.task_1508_Range_Sum_of_Sorted_Subarray_Sums;

import java.util.PriorityQueue;

// from leetcode editorial (Approach 2: Priority Queue)
public class Solution3 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int ans = 0;
        int mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            int[] p = pq.poll();
            if (i >= left) {
                ans = (ans + p[0]) % mod;
            }
            if (p[1] < n - 1) {
                p[0] += nums[++p[1]];
                pq.offer(p);
            }
        }
        return ans;
    }
}
package matrix.workingPeoplesImitation.task_2874_Maximum_Value_of_an_Ordered_Triplet_II;

// from leetcode code sample (1)
public class Solution5 {
    public long maximumTripletValue(int[] a) {
        int n = a.length, maxRight = 0, maxLeft = a[0];
        long res = 0;
        int[] b = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            b[i] = maxRight;
            maxRight = Math.max(maxRight, a[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (long) b[i] * (maxLeft - a[i]));
            maxLeft = Math.max(maxLeft, a[i]);
        }
        return res;
    }
}

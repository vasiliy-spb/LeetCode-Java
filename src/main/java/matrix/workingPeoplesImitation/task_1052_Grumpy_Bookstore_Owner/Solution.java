package matrix.workingPeoplesImitation.task_1052_Grumpy_Bookstore_Owner;

// my solution
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int countSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                countSatisfied += customers[i];
                customers[i] = 0;
            }
        }
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + customers[i];
        }
        int add = 0;
        for (int i = 0; i <= n - minutes; i++) {
            add = Math.max(add, prefixSum[i + minutes] - prefixSum[i]);
        }
        return countSatisfied + add;
    }
}

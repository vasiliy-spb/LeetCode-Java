package matrix.workingPeoplesImitation.task_1052_Grumpy_Bookstore_Owner;

// from leetcode code sample
public class Solution5 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int maxSatisfaction = 0;

        // Calculate the base satisfaction when the owner is not grumpy
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                maxSatisfaction += customers[i];
            }
        }

        // Calculate the sum for the first window (first 'minutes' period)
        int sum = 0;
        for (int a = 0; a < minutes; a++) {
            if (grumpy[a] == 1) {
                sum += customers[a];
            }
        }

        // Initialize maxWindow with the sum from the first window
        int maxWindow = sum;

        // Set `j` to `minutes` to start sliding the window from there
        int i = 0, j = minutes;

        // Sliding the window across the array
        while (j < n) {
            // Remove the outgoing element (i) and add the incoming element (j)
            if (grumpy[i] == 1) {
                sum -= customers[i];
            }
            if (grumpy[j] == 1) {
                sum += customers[j];
            }

            // Update maxWindow with the maximum value
            maxWindow = Math.max(maxWindow, sum);

            // Slide the window forward
            i++;
            j++;
        }

        // Return the total maximum satisfaction: base satisfaction + best window improvement
        return maxSatisfaction + maxWindow;
    }
}

package matrix.workingPeoplesImitation.task_440_K_th_Smallest_in_Lexicographical_Order;

// my solution (after detailed explanation from GPT)
public class Solution6 {
    public int findKthNumber(int n, int k) {
        long current = 1;
        k--;
        while (k > 0) {
            long stepsCount = calculateSteps(current, current + 1, n);
            if (stepsCount <= k) {
                k -= stepsCount;
                current++;
            } else {
                current *= 10;
                k--;
            }
        }
        return (int) current;
    }
    private long calculateSteps(long current, long next, int n) {
        long step = 0;
        while (current <= n) {
            step += Math.min(next, n + 1) - current;
            current *= 10;
            next *= 10;
        }
        return step;
    }
}

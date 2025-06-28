package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

import java.util.Random;

import static java.util.Arrays.binarySearch;

// my solution
public class Solution {
    int[] weights;
    int[] prefixSum;
    Random random;

    public Solution(int[] w) {
        this.weights = w;
        this.prefixSum = calculatePrefixSum(w);
        this.random = new Random();
    }

    private int[] calculatePrefixSum(int[] w) {
        int[] ps = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            ps[i + 1] += ps[i] + w[i];
        }
        return ps;
    }

    public int pickIndex() {
        int valueInPrefix = random.nextInt(prefixSum[prefixSum.length - 1]);
        int position = binarySearch(prefixSum, 0, prefixSum.length, valueInPrefix);
        if (position < 0) {
            return Math.abs(position) - 2;
        }
        return position;
    }
}

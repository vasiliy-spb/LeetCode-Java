package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

import java.util.Arrays;
import java.util.Random;

// my solution (reimplement Solution3)
public class Solution7 {
    int[] frequencyWeights;
    Random random;
    int offset = 0;

    public Solution7(int[] w) {
        this.frequencyWeights = createFrequencyArray(w);
        this.random = new Random();
    }

    private int[] createFrequencyArray(int[] w) {
        int[] weights = new int[10_000];
        int totalWeight = calculateTotalWeight(w);
        for (int index = 0; index < w.length; index++) {
            int weight = w[index];
            int count = (weight * 100) / totalWeight;
            while (count-- > 0) {
                weights[offset++] = index;
            }
        }
        return weights;
    }

    private int calculateTotalWeight(int[] w) {
        return Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int index = 0;
        if (offset > 0) {
            index = random.nextInt(offset);
        }
        return frequencyWeights[index];
    }
}
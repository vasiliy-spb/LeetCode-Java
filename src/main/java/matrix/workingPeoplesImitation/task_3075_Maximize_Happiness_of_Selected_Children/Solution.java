package matrix.workingPeoplesImitation.task_3075_Maximize_Happiness_of_Selected_Children;

import java.util.Arrays;

public class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long count = 0;
        for (int i = 0; i < k; i++) {
            count += Math.max(0, happiness[happiness.length - 1 - i] - i);
        }
        return count;
    }
}

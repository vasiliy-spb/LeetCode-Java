package matrix.workingPeoplesImitation.task_3074_Apple_Redistribution_into_Boxes;

import java.util.Arrays;

// from walkccc.me
public class Solution3 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        final int appleSum = Arrays.stream(apple).sum();
        int capacitySum = 0;

        Arrays.sort(capacity);

        for (int i = 0; i < capacity.length; ++i) {
            capacitySum += capacity[capacity.length - 1 - i];
            if (capacitySum >= appleSum) {
                return i + 1;
            }
        }

        return capacity.length;
    }
}

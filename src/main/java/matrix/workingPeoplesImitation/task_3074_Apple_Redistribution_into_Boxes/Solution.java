package matrix.workingPeoplesImitation.task_3074_Apple_Redistribution_into_Boxes;

import java.util.Arrays;

// my solution
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (capacity[i] >= sum) {
                return capacity.length - i;
            }
            sum -= capacity[i];
        }
        return capacity.length;
    }
}

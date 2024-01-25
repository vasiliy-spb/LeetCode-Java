package matrix.workingPeoplesImitation.task_2951_Find_the_Peaks;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] >= mountain[i]) continue;
            if (mountain[i] > mountain[i + 1]) result.add(i++);
        }
        return result;
    }
}

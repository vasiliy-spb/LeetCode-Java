package matrix.workingPeoplesImitation.task_1968_Array_With_Elements_Not_Equal_to_Average_of_Neighbors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// my solution (fun approach)
public class Solution {
    public int[] rearrangeArray(int[] nums) {
        w: while (true) {
            List<Integer> list = new java.util.ArrayList<>(Arrays.stream(nums).boxed().toList());
            Collections.shuffle(list);
            int[] result = list.stream().mapToInt(Integer::intValue).toArray();

            for (int i = 1; i < result.length - 1; i++) {
                if (result[i] == (result[i - 1] + result[i + 1]) / 2) {
                    result[i] += result[i - 1];
                    result[i - 1] = result[i] - result[i - 1];
                    result[i] -= result[i - 1];
                }
                if (result[i] == (result[i - 1] + result[i + 1]) / 2) {
                    result[i] += result[i + 1];
                    result[i + 1] = result[i] - result[i + 1];
                    result[i] -= result[i + 1];
                }
                if (result[i] == (result[i - 1] + result[i + 1]) / 2) {
                    continue w;
                }
            }
            return result;
        }
    }
}

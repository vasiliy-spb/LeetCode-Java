package matrix.workingPeoplesImitation.task_66_Plus_One;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// my solution
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        List<Integer> list = new ArrayList<>();
        int add = 0;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += add;
            add = 0;
            if (digits[i] == 10) {
                list.add(0);
                add++;
            } else {
                list.add(digits[i]);
            }
        }
        if (add > 0) {
            list.add(add);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

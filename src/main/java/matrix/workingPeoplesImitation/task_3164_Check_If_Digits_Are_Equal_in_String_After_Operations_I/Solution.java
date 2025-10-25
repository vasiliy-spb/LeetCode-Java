package matrix.workingPeoplesImitation.task_3164_Check_If_Digits_Are_Equal_in_String_After_Operations_I;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public boolean hasSameDigits(String s) {
        List<Integer> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            list.add(Character.getNumericValue(ch));
        }
        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>(list.size() - 1);
            for (int i = 1; i < list.size(); i++) {
                int prev = list.get(i - 1);
                int curr = list.get(i);
                temp.add((curr + prev) % 10);
            }
            list = temp;
        }
        return list.get(0) == list.get(1);
    }
}

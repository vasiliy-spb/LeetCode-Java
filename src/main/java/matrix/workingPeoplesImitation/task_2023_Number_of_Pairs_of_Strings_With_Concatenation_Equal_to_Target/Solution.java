package matrix.workingPeoplesImitation.task_2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target;

import java.util.*;

public class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> headMap = new HashMap<>();
        Map<Integer, Integer> tailMap = new HashMap<>();
        int count = 0;
        for (String num : nums) {
            if ((num + num).equals(target)) {
                count--;
            }
            if (target.startsWith(num)) {
                headMap.merge(num, 1, Integer::sum);
            }
            if (target.endsWith(num)) {
                tailMap.merge(num.length(), 1, Integer::sum);
            }
        }
        for (String head : headMap.keySet()) {
            count += tailMap.getOrDefault(target.length() - head.length(), 0) * headMap.get(head);
        }
        return count;
    }
}

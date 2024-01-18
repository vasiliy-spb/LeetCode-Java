package matrix.workingPeoplesImitation.task_1207_Unique_Number_of_Occurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.merge(num, 1, Integer::sum);
        }
        Set<Integer> countSet = new HashSet<>(map.values());
        return countSet.size() == map.values().size();
    }
}

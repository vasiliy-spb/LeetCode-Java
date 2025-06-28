package matrix.workingPeoplesImitation.task_1481_Least_Number_of_Unique_Integers_after_K_Removals;

import java.util.*;

public class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            frequencyMap.merge(arr[i], 1, Integer::sum);

        List<Integer> frequency = new ArrayList<>(frequencyMap.values());

        Collections.sort(frequency);

        for (int i = 0; i < frequency.size(); i++) {
            k -= frequency.get(i);
            if (k < 0) return frequency.size() - i;
        }
        return k == 0 ? k : frequency.size();
    }

    public int findLeastNumOfUniqueInts1(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            frequencyMap.merge(arr[i], 1, Integer::sum);
        TreeSet<Map.Entry<Integer, Integer>> entrySet = new TreeSet<>((entry1, entry2) -> {
            if (entry1.getValue() == entry2.getValue()) {
                return entry1.getKey() - entry2.getKey();
            }
            return entry1.getValue() - entry2.getValue();
        });
        entrySet.addAll(frequencyMap.entrySet());
        int count = frequencyMap.size();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            k -= entry.getValue();
            if (k < 0) break;
            count--;
        }
        return count;
    }
}

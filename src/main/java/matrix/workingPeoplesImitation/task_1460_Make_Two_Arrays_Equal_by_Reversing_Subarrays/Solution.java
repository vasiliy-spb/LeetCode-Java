package matrix.workingPeoplesImitation.task_1460_Make_Two_Arrays_Equal_by_Reversing_Subarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    // my solution
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : target) {
            map.merge(t, 1, Integer::sum);
        }
        for (int a : arr) {
            map.merge(a, -1, Integer::sum);
            if (map.get(a) == 0) {
                map.remove(a);
            }
        }
        return map.size() == 0;
    }

    // from leetcode editorial (Approach 1: Sorting)
    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) return false;
        }
        return true;
    }

    // from leetcode editorial (Approach 2: Frequency Counting With 2 Dictionaries)
    public boolean canBeEqual3(int[] target, int[] arr) {
        // Dictionary to maintain frequency count for arr
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        // Dictionary to maintain frequency count for target
        Map<Integer, Integer> targetFreq = new HashMap<>();
        for (int num : target) {
            targetFreq.put(num, targetFreq.getOrDefault(num, 0) + 1);
        }

        // Number of distinct elements of the 2 arrays are not equal
        if (arrFreq.keySet().size() != targetFreq.keySet().size()) {
            return false;
        }

        for (int num : arrFreq.keySet()) {
            // Frequency for num differs
            if (targetFreq.getOrDefault(num, 0) != arrFreq.get(num)) {
                return false;
            }
        }

        return true;
    }

    // from leetcode editorial (Approach 3: Frequency Counting With 1 Dictionary)
    public boolean canBeEqual4(int[] target, int[] arr) {
        // Frequency count for arr
        Map<Integer, Integer> arrFreq = new HashMap<>();
        for (int num : arr) {
            arrFreq.put(num, arrFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : target) {
            // If num does not appear in target, then arrays are not equal
            if (!arrFreq.containsKey(num)) return false;

            // Decrement the frequency count for num and
            // remove key if the count goes to 0
            arrFreq.put(num, arrFreq.get(num) - 1);
            if (arrFreq.get(num) == 0) {
                arrFreq.remove(num);
            }
        }
        return arrFreq.size() == 0;
    }

    // from walkccc.me
    public boolean canBeEqual5(int[] target, int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .equals(Arrays.stream(target).boxed().collect(
                        Collectors.groupingBy(Integer::intValue, Collectors.counting())));
    }

}

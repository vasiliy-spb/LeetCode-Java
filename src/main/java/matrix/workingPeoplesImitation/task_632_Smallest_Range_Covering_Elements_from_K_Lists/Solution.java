package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.*;

// my solution
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Set<Integer> tempSet = new TreeSet<>();
        List<Set<Integer>> numsSet = new ArrayList<>();
        for (List<Integer> list : nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : list) {
                set.add(num);
                tempSet.add(num);
            }
            numsSet.add(set);
        }
        int[] arr = tempSet.stream().mapToInt(Integer::intValue).toArray();
        int n = arr.length;

        int min = arr[0];
        int max = arr[n - 1];
        int range = max - min;
        boolean allIn = false;
        Map<Integer, Integer> indexSetMap = new HashMap<>();
        for (int right = 0, left = 0; right < n; ) {
            if (!allIn) {
                for (int i = 0; i < numsSet.size(); i++) {
                    Set<Integer> set = numsSet.get(i);
                    if (set.contains(arr[right])) {
                        indexSetMap.merge(i, 1, Integer::sum);
                    }
                }
                allIn = indexSetMap.size() == nums.size();
                if (allIn) {
                    if (arr[right] - arr[left] < range) {
                        range = arr[right] - arr[left];
                        min = arr[left];
                        max = arr[right];
                    }
                }
                while (allIn && left <= right) {
                    for (int i = 0; i < numsSet.size(); i++) {
                        Set<Integer> set = numsSet.get(i);
                        if (set.contains(arr[left])) {
                            indexSetMap.merge(i, -1, Integer::sum);
                            indexSetMap.remove(i, 0);
                        }
                    }
                    left++;
                    allIn = indexSetMap.size() == nums.size();
                    if (allIn) {
                        if (arr[right] - arr[left] < range) {
                            range = arr[right] - arr[left];
                            min = arr[left];
                            max = arr[right];
                        }
                    }
                }
                right++;
            }
        }
        return new int[]{min, max};
    }
}

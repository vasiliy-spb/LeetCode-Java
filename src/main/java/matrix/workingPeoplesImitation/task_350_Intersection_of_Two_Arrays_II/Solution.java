package matrix.workingPeoplesImitation.task_350_Intersection_of_Two_Arrays_II;

import java.util.*;

public class Solution {

    // my solution
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1)
            map.merge(i, 1, Integer::sum);
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                map.merge(i, -1, Integer::sum);
                if (map.get(i) == 0) map.remove(i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // from leetcode code sample
    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int[] result = new int[1001];

        for (int num : nums1) {
            arr[num]++;
        }

        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }

        return Arrays.copyOfRange(result, 0, ctr);
    }

}

package matrix.workingPeoplesImitation.task_349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1)
            set.add(num);
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2)
            if (set.contains(num))
                intersect.add(num);
        int[] result = new int[intersect.size()];
        int index = 0;
        for (int i : intersect)
            result[index++] = i;
        return result;
    }
}

package matrix.workingPeoplesImitation.task_1865_Finding_Pairs_With_a_Certain_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// my solution
public class FindSumPairs {
    private final int[] nums1;
    private final int[] nums2;
    private final Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        Arrays.sort(nums1);
        this.nums2 = nums2;
        this.map = new HashMap<>();
        for (int num2 : nums2) {
            map.merge(num2, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        int prevNum = nums2[index];
        map.merge(prevNum, -1, Integer::sum);
        map.merge(prevNum + val, 1, Integer::sum);
        nums2[index] += val;
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            count += map.getOrDefault(complement, 0);
        }
        return count;
    }
}

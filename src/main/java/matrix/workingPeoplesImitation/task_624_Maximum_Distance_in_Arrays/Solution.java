package matrix.workingPeoplesImitation.task_624_Maximum_Distance_in_Arrays;

import java.util.List;

public class Solution {

    // my solution (TLE)
    public int maxDistance0(List<List<Integer>> arrays) {
        int diff = 0;
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> list1 = arrays.get(i);
                List<Integer> list2 = arrays.get(j);
                diff = Math.max(diff, Math.abs(list1.get(list1.size() - 1) - list2.get(0)));
            }
        }
        return diff;
    }

    // my solution
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE;
        int min1index = -1;
        int min2 = Integer.MAX_VALUE;
        int min2index = -1;
        int max1 = Integer.MIN_VALUE;
        int max1index = -1;
        int max2 = Integer.MIN_VALUE;
        int max2index = -1;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int currentMin = list.get(0);
            int currentMax = list.get(list.size() - 1);
            if (currentMin < min1) {
                min2 = min1;
                min2index = min1index;
                min1 = currentMin;
                min1index = i;
            } else if (currentMin < min2) {
                min2 = currentMin;
                min2index = i;
            }
            if (currentMax > max1) {
                max2 = max1;
                max2index = max1index;
                max1 = currentMax;
                max1index = i;
            } else if (currentMax > max2) {
                max2 = currentMax;
                max2index = i;
            }
        }
        int diff = 0;
        if (min1index != max1index) {
            diff = Math.max(diff, Math.abs(max1 - min1));
        }
        if (max1index != min2index) {
            diff = Math.max(diff, Math.abs(max1 - min2));
        }
        if (max2index != min1index) {
            diff = Math.max(diff, Math.abs(max2 - min1));
        }
        if (max2index != min2index) {
            diff = Math.max(diff, Math.abs(max2 - min2));
        }
        return diff;
    }

    // from walkccc.me
    public int maxDistance2(List<List<Integer>> arrays) {
        int ans = 0;
        int mn = 10000;
        int mx = -10000;

        for (List<Integer> A : arrays) {
            ans = Math.max(ans, Math.max(A.get(A.size() - 1) - mn, mx - A.get(0)));
            mn = Math.min(mn, A.get(0));
            mx = Math.max(mx, A.get(A.size() - 1));
        }

        return ans;
    }

}

package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from leetcode code sample (5)
public class Solution10 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int num : nums.get(i)) {
                pairs.add(new int[]{num, i});
            }
        }

        Collections.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] cnt = new int[n];
        int res = Integer.MAX_VALUE;
        int resL = 0, resR = 0;

        int left = 0;
        for (int right = 0; right < pairs.size(); right++) {
            int value = pairs.get(right)[0];
            int group = pairs.get(right)[1];

            cnt[group]++;
            if (cnt[group] == 1) {
                n--;
            }

            while (n == 0) {
                if (pairs.get(right)[0] - pairs.get(left)[0] < res) {
                    res = pairs.get(right)[0] - pairs.get(left)[0];
                    resL = pairs.get(left)[0];
                    resR = pairs.get(right)[0];
                }

                int valL = pairs.get(left)[0];
                int groupL = pairs.get(left++)[1];

                cnt[groupL]--;
                if (cnt[groupL] == 0) {
                    n++;
                }
            }
        }


        return new int[]{resL, resR};
    }
}

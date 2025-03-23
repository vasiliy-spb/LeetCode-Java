package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from leetcode code sample (4)
public class Solution9 {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j : nums.get(i)) {
                list.add(new int[]{j, i});
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        int[] counter = new int[n];
        int[] res = new int[2];
        int total = 0;
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i)[0];
            int idx = list.get(i)[1];
            if (counter[idx] == 0) {
                total++;
            }
            counter[idx]++;
            while (j < i && counter[list.get(j)[1]] > 1) {
                counter[list.get(j++)[1]]--;
            }
            if (total == n) {
                if (res[0] == 0 && res[1] == 0 || list.get(i)[0] - list.get(j)[0] < res[1] - res[0]) {
                    res[0] = list.get(j)[0];
                    res[1] = list.get(i)[0];
                }
            }
        }
        return res;
    }
}

package matrix.workingPeoplesImitation.task_1943_Describe_the_Painting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// from leetcode code sample (1)
public class Solution3 {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n = 0;
        for (int[] seg : segments) n = Math.max(n, seg[1]);

        long[] col = new long[n + 1];
        boolean[] bounds = new boolean[n + 1];

        for (int[] seg : segments) {
            col[seg[0]] += seg[2];
            col[seg[1]] -= seg[2];
            bounds[seg[0]] = true;
            bounds[seg[1]] = true;
        }

        List<List<Long>> res = new ArrayList<>();
        long prev = 0, color = 0;

        for (int cur = 0; cur <= n; cur++) {
            if (bounds[cur] && color > 0) res.add(Arrays.asList(prev + 0L, cur + 0L, color));
            if (bounds[cur]) prev = cur;
            color += col[cur];
        }
        return res;
    }
}

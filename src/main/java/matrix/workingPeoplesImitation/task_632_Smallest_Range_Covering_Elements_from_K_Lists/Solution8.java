package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from leetcode code sample (3)
public class Solution8 {
    // https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/solutions/356248/xin-ping-zhuang-jiu-jiu-zhe-ti-jiu-shi-he-bing-kge/
    // https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/solutions/240717/pai-xu-hua-chuang-by-netcan/

    public int[] smallestRange(List<List<Integer>> nums) {
        // int k = nums.size();
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // int max = nums.get(0).get(0);
        // int start = -100000;
        // int end = 100000;
        // for (int i = 0; i < k; i++) {
        //     int val = nums.get(i).get(0);
        //     pq.offer(new int[]{i, 0, val});
        //     max = Math.max(max, val);
        // }

        // while (pq.size() == k) {
        //     int[] curr = pq.poll();
        //     int i = curr[0];
        //     int j = curr[1];
        //     int min = curr[2];
        //     if (max - min < end - start) {
        //         end = max;
        //         start = min;
        //     }
        //     if (j + 1 < nums.get(i).size()) {
        //         int val = nums.get(i).get(j + 1);
        //         pq.offer(new int[]{i, j + 1, val});
        //         max = Math.max(max, val);
        //     }
        // }
        // return new int[]{start, end};

        int k = nums.size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int x : nums.get(i)) {
                list.add(new int[]{x, i});
            }
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        int count = 0;
        int[] window = new int[k];
        int right = 0;
        int left = 0;
        int start = -100000;
        int end = 100000;
        while (right < list.size()) {
            int rightVal = list.get(right)[0];
            int rightGroup = list.get(right)[1];
            if (window[rightGroup] == 0) {
                count++;
            }
            window[rightGroup]++;
            right++;

            while (count == k) {
                int leftVal = list.get(left)[0];
                int leftGroup = list.get(left)[1];
                if (rightVal - leftVal < end - start) {
                    end = rightVal;
                    start = leftVal;
                }

                window[leftGroup]--;
                if (window[leftGroup] == 0) {
                    count--;
                }
                left++;
            }
        }
        return new int[]{start, end};
    }
}

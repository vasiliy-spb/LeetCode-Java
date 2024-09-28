package matrix.workingPeoplesImitation.task_3255_Find_the_Power_of_K_Size_Subarrays_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// from leetcode code sample (11)
public class Solution13 {
    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;

        LinkedList<Integer> list = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();

        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];
            list.add(nums[i]);
            if (list.size() == k) {

                int f = list.getFirst();
                int l = list.getLast();

                long result = nsum(l) - nsum(f - 1);

                if (sum == result) {
                    ans.add(l);
                } else {
                    ans.add(-1);
                }
                int last = list.removeFirst();
                sum -= last;
            }
        }

        int sz = ans.size();

        int[] res = new int[sz];

        for (int i = 0; i < sz; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }


    long nsum(long n) {
        return n * (n + 1) / 2;
    }
}

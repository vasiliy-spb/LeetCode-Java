package matrix.workingPeoplesImitation.task_239_Sliding_Window_Maximum;

import java.util.*;

// my solution
public class Solution {

    // Accepted
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int index = 0;
        while (index < k) {
            map.merge(nums[index++], 1, Integer::sum);
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = map.lastKey();
        for (int i = index; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
            map.merge(nums[i - k], -1, Integer::sum);
            map.remove(nums[i - k], 0);
            ans[i - k + 1] = map.lastKey();
        }
        return ans;
    }
    // WA
    public int[] maxSlidingWindow1(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int index = 0;
        while (set.size() < k) {
            set.add(nums[index++]);
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = set.last();
        for (int i = index; i < n; i++) {
            set.add(nums[i]);
            set.remove(nums[i - k]);
            ans[i - k + 1] = set.last();
        }
        return ans;
    }

    // TLE
    public int[] maxSlidingWindow0(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        while (queue.size() < k) {
            queue.offer(nums[index++]);
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = queue.peek();
        for (int i = index; i < n; i++) {
            queue.offer(nums[i]);
            queue.remove(nums[i - k]);
            ans[i - k + 1] = queue.peek();
        }
        return ans;
    }
}

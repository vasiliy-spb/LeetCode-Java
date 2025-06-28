package matrix.workingPeoplesImitation.task_1636_Sort_Array_by_Increasing_Frequency;

import java.util.*;

public class Solution {

    // my solution
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        TreeMap<Integer, Set<Integer>> fMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            fMap.computeIfAbsent(entry.getValue(), set -> new TreeSet<>(Comparator.reverseOrder())).add(entry.getKey());
        }
        int index = 0;
        while (index < nums.length) {
            for (Map.Entry<Integer, Set<Integer>> entry : fMap.entrySet()) {
                for (int num : entry.getValue()) {
                    int count = entry.getKey();
                    while (count > 0) {
                        nums[index++] = num;
                        count--;
                    }
                }
            }
        }
        return nums;
    }

    // from leetcode editorial (Approach: Customized Sorting)
    public int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        // Convert numsObj back to a primitive array to match
        // return type.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }

    // from walkccc.me
    class T {
        public int num;
        public int freq;
        public T(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    };

    public int[] frequencySort3(int[] nums) {
        int[] ans = new int[nums.length];
        int ansIndex = 0;
        Map<Integer, Integer> count = new HashMap<>();
        Queue<T> heap =
                new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.num - a.num : a.freq - b.freq);

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        for (Map.Entry<Integer, Integer> entry : count.entrySet())
            heap.offer(new T(entry.getKey(), entry.getValue()));

        while (!heap.isEmpty()) {
            final int num = heap.peek().num;
            final int freq = heap.poll().freq;
            for (int i = 0; i < freq; ++i)
                ans[ansIndex++] = num;
        }

        return ans;
    }

}

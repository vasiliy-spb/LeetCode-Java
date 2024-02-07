package matrix.workingPeoplesImitation.task_347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {

    // my solution
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.merge(num, 1, Integer::sum);
        int[] answer = new int[k];
        Map.Entry<Integer, Integer>[] entries = new Map.Entry[map.size()];
        map.entrySet().toArray(entries);
        Arrays.sort(entries, (e1, e2) -> e2.getValue() - e1.getValue());
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries)
            if (index < k) answer[index++] = entry.getKey();
        return answer;
    }

    // from GPT
    public static int[] topKFrequent1(int[] nums, int k) {
        // Step 1: Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a PriorityQueue to keep track of the k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if the size exceeds k
            }
        }

        // Step 3: Extract the elements from the PriorityQueue
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }

    // from walkccc.me
    public int[] topKFrequent2(int[] nums, int k) {
        final int n = nums.length;
        int[] ans = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (final int num : nums)
            count.merge(num, 1, Integer::sum);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            final int num = entry.getKey();
            final int freq = entry.getValue();
            minHeap.offer(new T(num, freq));
            if (minHeap.size() > k)
                minHeap.poll();
        }

        for (int i = 0; i < k; ++i)
            ans[i] = minHeap.poll().num;

        return ans;
    }
    class T {
        public int num;
        public int freq;
        public T(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}

package matrix.workingPeoplesImitation.task_1985_Find_the_Kth_Largest_Integer_in_the_Array;

import java.math.BigInteger;
import java.util.*;

public class Solution {

    // my solution (after leetcode hints)
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) < s2.charAt(i)) return 1;
                    if (s1.charAt(i) > s2.charAt(i)) return -1;
                }
                return 0;
            } else {
                return s2.length() > s1.length() ? 1 : -1;
            }
        });
        return nums[k - 1];
    }

    // my solution
    public String kthLargestNumber0(String[] nums, int k) {
        TreeMap<BigInteger, List<Integer>> map = new TreeMap<>((a, b) -> b.compareTo(a));
        for (int i = 0; i < nums.length; i++) {
            BigInteger key = new BigInteger(nums[i]);
            List<Integer> list =  map.getOrDefault(key, new ArrayList<>());
            list.add(i);
            map.put(key, list);
        }
        for (Map.Entry<BigInteger, List<Integer>> entry : map.entrySet()) {
            k -= entry.getValue().size();
            if (k <= 0) return nums[entry.getValue().get(0)];
        }
        return "";
    }

    // from walkccc.me
    // Similar to 215. Kth Largest Element in an Array
    public String kthLargestNumber2(String[] nums, int k) {
        Queue<String> minHeap = new PriorityQueue<>(
                (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

        for (final String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.poll();
    }

    // from leetcode solutions (Big Int)
    public String kthLargestNumber3(String[] nums, int k) {
        Arrays.sort(nums,(a,b)->new BigInteger(b).compareTo(new BigInteger(a)));
        return nums[k-1];
    }

    // from leetcode solutions (custom Comparator)
    public static String kthLargestNumber4(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> {
            if (b.length() != a.length()) return b.length() - a.length();
            return b.compareTo(a);
        });
        return nums[k - 1];
    }

    // from leetcode solutions (HEAP)
    public static String kthLargestNumberHeap(String[] nums, int k) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.length() != a.length()) return b.length() - a.length();
            return b.compareTo(a);
        });
        for (String s : nums) {
            maxHeap.add(s);
        }
        while (k > 1) {
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();
    }

    // from leetcode solutions (MinHeap)
    // For C++, Java: We need to custom our comparator since the default comparator is string comparator which compares by lexicographically order, it means for example: "123" < "14".
    // The idea is that we use minHeap to store up to k largest elements so far, where the top of the minHeap is the kth largest element.
    public String kthLargestNumber5(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) { // If the same length then compare by their string
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length()); // Compare by their length
        });
        for (String num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // pop the minimum value in the heap
            }
        }
        return minHeap.poll();
    }

    // from GPT
    public static String kthLargestNumber6(String[] nums, int k) {
        // Custom comparator to sort strings based on numerical values in descending order
        Comparator<String> customComparator = (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b); // If lengths are equal, compare lexicographically
            }
            return Integer.compare(a.length(), b.length());
        };

        // Sort the array in descending order using the custom comparator
        Arrays.sort(nums, customComparator.reversed());

        // Return the kth element in the sorted array
        return nums[k - 1];
    }
}

package matrix.workingPeoplesImitation.task_128_Longest_Consecutive_Sequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

    // my solution
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums)
            set.add(num);
        int prev = Integer.MAX_VALUE;
        int count = 1;
        int currentCount = 1;
        for (int num : set) {
            if (num - prev == 1) {
                currentCount++;
                count = Math.max(count, currentCount);
            } else {
                currentCount = 1;
            }
            prev = num;
        }
        return count;
    }

    // from leetcode Solutions (https://leetcode.com/problems/longest-consecutive-sequence/solutions/3171985/best-c-4-solution-hash-table-sorting-brute-force-optimize-one-stop-solution/?envType=study-plan-v2&envId=top-interview-150)
    public int longestConsecutive2(int[] nums) {
        // Create a HashMap to store each integer from the input array
        // with a boolean value indicating if it has been visited or not
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Populate the HashMap with each integer from the input array
        // Mark all integers as true (not visited yet)
        for (int num : nums) {
            map.put(num, true);
        }

        // Iterate through the array again
        // For each integer, if its predecessor (num - 1) exists in the map,
        // mark the current integer as false, indicating it's not the start of a sequence
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, false);
            }
        }

        // Initialize a variable to store the maximum length of consecutive sequence
        int maxlen = 0;

        // Iterate through the array again
        for (int num : nums) {
            // Check if the current integer is the start of a sequence (true in the map)
            if (map.get(num)) {
                int j = 0; // Initialize a counter to count consecutive elements
                int count = 0; // Initialize a variable to store the count of consecutive elements
                // Iterate forward as long as consecutive elements exist in the map
                while (map.containsKey(num + j)) {
                    j++;
                    count++; // Increment count for each consecutive element found
                }
                // Update maxlen if the current sequence is longer than the previously recorded one
                if (count > maxlen) {
                    maxlen = count;
                }
            }
        }
        // Return the length of the longest consecutive sequence found
        return maxlen;
    }

    // from walkccc.me
    public int longestConsecutive3(int[] nums) {
        int ans = 0;
        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            // `num` is the start of a sequence.
            if (seen.contains(num - 1))
                continue;
            int length = 1;
            while (seen.contains(++num))
                ++length;
            ans = Math.max(ans, length);
        }

        return ans;
    }

}

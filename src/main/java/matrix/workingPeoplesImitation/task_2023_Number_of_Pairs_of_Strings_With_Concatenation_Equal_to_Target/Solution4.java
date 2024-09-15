package matrix.workingPeoplesImitation.task_2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target;

import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (2)
public class Solution4 {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> countMap = new HashMap<>();
        int result = 0;

        // Count the occurrences of each string in the nums array
        for (String num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through each number in the nums array
        for (String num : nums) {
            // Check if num can be a valid prefix for the target
            if (target.startsWith(num)) {
                String suffix = target.substring(num.length());

                // Check if the suffix exists in the count map
                if (countMap.containsKey(suffix)) {
                    result += countMap.get(suffix);

                    // If num and suffix are the same, avoid counting it as a pair with itself
                    if (num.equals(suffix)) {
                        result--;
                    }
                }
            }
        }

        return result;
    }
}

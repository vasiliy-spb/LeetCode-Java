package matrix.workingPeoplesImitation.task_2023_Number_of_Pairs_of_Strings_With_Concatenation_Equal_to_Target;

import java.util.HashMap;
import java.util.Map;

// from walkccc.me
public class Solution2 {
    public int numOfPairs(String[] nums, String target) {
        final int n = target.length();
        int ans = 0;
        Map<String, Integer> count = new HashMap<>();

        for (final String num : nums) {
            final int k = num.length();
            if (k >= n)
                continue;
            if (target.substring(0, k).equals(num))
                ans += count.getOrDefault(target.substring(k), 0);
            if (target.substring(n - k).equals(num))
                ans += count.getOrDefault(target.substring(0, n - k), 0);
            count.merge(num, 1, Integer::sum);
        }

        return ans;
    }
}

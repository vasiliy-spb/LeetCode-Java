package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

import java.util.HashSet;
import java.util.Set;

// from leetcode editorial (Approach 2: Iterate Over Integer Equivalents)
public class Solution4 {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }

        int n = nums.length;
        for (int num = 0; num <= n; num++) {
            if (!integers.contains(num)) {
                String ans = Integer.toBinaryString(num);
                while (ans.length() < n) {
                    ans = "0" + ans;
                }

                return ans;
            }
        }

        return "";
    }
}

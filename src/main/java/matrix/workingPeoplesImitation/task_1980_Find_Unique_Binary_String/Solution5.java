package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// from leetcode editorial (Approach 3: Random)
public class Solution5 {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> integers = new HashSet();
        for (String num : nums) {
            integers.add(Integer.parseInt(num, 2));
        }

        int ans = Integer.parseInt(nums[0], 2);
        int n = nums.length;
        Random rand = new Random();

        while (integers.contains(ans)) {
            ans = rand.nextInt((int) Math.pow(2, n));
        }

        String s = Integer.toBinaryString(ans);
        while (s.length() < n) {
            s = "0" + s;
        }

        return s;
    }
}

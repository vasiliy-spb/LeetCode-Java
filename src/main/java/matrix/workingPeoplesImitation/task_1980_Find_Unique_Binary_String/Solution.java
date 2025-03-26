package matrix.workingPeoplesImitation.task_1980_Find_Unique_Binary_String;

import java.util.HashSet;
import java.util.Set;

// my solution
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = new HashSet<>();
        for (String s : nums) {
            numsSet.add(s);
        }
        String[] ans = {""};
        generateUniqueString("", nums[0].length(), numsSet, ans);
        return ans[0];
    }
    private void generateUniqueString(String current, int n, Set<String> numsSet, String[] ans) {
        if (!ans[0].isEmpty()) {
            return;
        }
        if (current.length() == n) {
            if (!numsSet.contains(current)) {
                ans[0] = current;
            }
            return;
        }
        generateUniqueString(current + "1", n, numsSet, ans);
        generateUniqueString(current + "0", n, numsSet, ans);
    }
}

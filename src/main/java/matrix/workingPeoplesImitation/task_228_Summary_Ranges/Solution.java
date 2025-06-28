package matrix.workingPeoplesImitation.task_228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                if (nums[i + 1] - nums[i] == 1) {
                    length++;
                } else {
                    if (length == 0) {
                        ans.add(String.valueOf(nums[i]));
                    } else {
                        ans.add(nums[i - length] + "->" + nums[i]);
                        length = 0;
                    }
                }
            } else {
                if (length == 0) {
                    ans.add(String.valueOf(nums[i]));
                } else {
                    ans.add(nums[i - length] + "->" + nums[i]);
                }
            }
        }
        return ans;
    }
}

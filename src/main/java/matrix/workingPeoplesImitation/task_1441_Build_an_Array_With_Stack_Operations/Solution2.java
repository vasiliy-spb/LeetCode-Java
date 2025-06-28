package matrix.workingPeoplesImitation.task_1441_Build_an_Array_With_Stack_Operations;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach: Simulate)
public class Solution2 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        int i = 0;

        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }

            ans.add("Push");
            i++;
        }

        return ans;
    }
}

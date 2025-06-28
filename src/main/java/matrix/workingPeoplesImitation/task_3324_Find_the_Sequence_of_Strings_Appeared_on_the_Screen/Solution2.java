package matrix.workingPeoplesImitation.task_3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen;

import java.util.ArrayList;
import java.util.List;

// from https://github.com/doocs/leetcode/blob/main/solution/3300-3399/3324.Find%20the%20Sequence%20of%20Strings%20Appeared%20on%20the%20Screen/README_EN.md
public class Solution2 {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        for (char c : target.toCharArray()) {
            String s = ans.isEmpty() ? "" : ans.get(ans.size() - 1);
            for (char a = 'a'; a <= c; ++a) {
                String t = s + a;
                ans.add(t);
            }
        }
        return ans;
    }
}

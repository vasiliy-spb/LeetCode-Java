package matrix.workingPeoplesImitation.task_3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution3 {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (final char targetChar : target.toCharArray()) {
            sb.append('a');
            ans.add(sb.toString());
            for (char c = 'b'; c < targetChar; ++c) {
                sb.setCharAt(sb.length() - 1, c);
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}

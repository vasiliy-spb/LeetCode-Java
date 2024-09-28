package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// my solution (accepted)
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        while (n > 0) {
            ans.add(n--);
        }
        ans.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return ans;
    }
}

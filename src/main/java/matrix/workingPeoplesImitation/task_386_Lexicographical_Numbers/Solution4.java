package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from walkccc.me
public class Solution4 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int curr = 1;

        while (ans.size() < n) {
            ans.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr == n)
                    curr /= 10;
                ++curr;
            }
        }

        return ans;
    }
}

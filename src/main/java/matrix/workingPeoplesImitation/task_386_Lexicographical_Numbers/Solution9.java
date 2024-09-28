package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (3)
public class Solution9 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1, size = 0;
        while (size < n) {
            res.add(cur);
            ++size;
            int t = (cur << 3) + (cur << 1);
            if (t <= n) {
                cur = t;
            } else {
                while (cur == n || cur % 10 == 9)
                    cur /= 10;
                ++cur;
            }
        }
        return res;
    }
}

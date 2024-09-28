package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (2)
public class Solution8 {
    void rec(int start, List<Integer> res, int n) {
        int t = (start << 3) + (start << 1);
        for (int i = 0; i < 10; i++) {
            int nex = t + i;
            if (nex > n)
                break;
            else {
                res.add(nex);
                rec(nex, res, n);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i <= n) {
                res.add(i);
                rec(i, res, n);
            }
        }
        return res;
    }
}

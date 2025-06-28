package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.AbstractList;
import java.util.List;

// from leetcode code sample (1)
public class Solution7 {
    public List<Integer> lexicalOrder(int n) {
        return new AbstractList<Integer>() {
            int[] result;

            public int size() {
                if (result == null) result = generate(n);
                return n;
            }

            public Integer get(int i) {
                return result[i];
            }
        };
    }

    int[] generate(int n) {
        int[] result = new int[n];
        int last = 1;
        int div = n / 10;
        for (int i = 0; i < n; i++) {
            result[i] = last;
            if (last <= div)
                last *= 10;
            else {
                while (last - last / 10 * 10 == 9 || last >= n) {
                    last /= 10;
                }
                last++;
            }

        }
        return result;
    }
}

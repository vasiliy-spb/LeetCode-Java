package matrix.workingPeoplesImitation.task_2138_Divide_a_String_Into_Groups_of_Size_k;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial
public class Solution3 {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>(); // grouped string
        int n = s.length();
        int curr = 0; // starting index of each group
        // split string
        while (curr < n) {
            int end = Math.min(curr + k, n);
            res.add(s.substring(curr, end));
            curr += k;
        }
        // try to fill in the last group
        String last = res.get(res.size() - 1);
        if (last.length() < k) {
            last += String.valueOf(fill).repeat(k - last.length());
            res.set(res.size() - 1, last);
        }
        return res.toArray(new String[0]);
    }
}

package matrix.workingPeoplesImitation.task_1545_Find_Kth_Bit_in_Nth_Binary_String;

import java.util.ArrayList;

// from leetcode code sample (2)
public class Solution8 {
    public char findKthBit(int n, int k) {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("0");
        ar.add("011");
        int i;
        for (i = 2; i < n; i++) {
            String s = ar.get(i - 1);
            String invert = s.charAt(s.length() / 2) == '0' ? "1" : "0";
            String sub = s.substring(s.length() / 2 + 1, s.length());
            ar.add(ar.get(i - 1) + "1" + ar.get(i - 2) + invert + sub);
        }
        return ar.get(n - 1).charAt(k - 1);
    }
}

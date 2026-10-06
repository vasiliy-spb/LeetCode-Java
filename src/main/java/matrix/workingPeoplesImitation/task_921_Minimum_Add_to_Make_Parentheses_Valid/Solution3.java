package matrix.workingPeoplesImitation.task_921_Minimum_Add_to_Make_Parentheses_Valid;

// from walkccc.me
public class Solution3 {
    public int minAddToMakeValid(String s) {
        int l = 0;
        int r = 0;

        for (final char c : s.toCharArray())
            if (c == '(') {
                ++l;
            } else {
                if (l == 0) {
                    ++r;
                } else {
                    --l;
                }
            }

        return l + r;
    }
}

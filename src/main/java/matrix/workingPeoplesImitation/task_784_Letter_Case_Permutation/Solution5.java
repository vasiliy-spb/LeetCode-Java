package matrix.workingPeoplesImitation.task_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (3)
public class Solution5 {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> list = new ArrayList();
        StringBuilder temp = new StringBuilder();
        ans(0, s, list, temp);
        return list;
    }

    public void ans(int i, String s, ArrayList<String> list, StringBuilder temp) {
        if (i == s.length()) {
            list.add(temp.toString());
            return;
        }
        temp.append(s.charAt(i));
        ans(i + 1, s, list, temp);
        temp.deleteCharAt(temp.length() - 1);
        if (Character.isLetter(s.charAt(i))) {
            if (Character.isLowerCase(s.charAt(i))) {
                temp.append(Character.toUpperCase(s.charAt(i)));
            }
            if (Character.isUpperCase(s.charAt(i))) {
                temp.append(Character.toLowerCase(s.charAt(i)));
            }
            ans(i + 1, s, list, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

package matrix.workingPeoplesImitation.task_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (1)
public class Solution3 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        createPermutations(0, res, s.toLowerCase().toCharArray());
        return res;
    }

    public void createPermutations(int index, List<String> res, char[] ch) {
        if (index == ch.length) {
            res.add(new String(ch));
            return;
        }

        createPermutations(index + 1, res, ch);
        if (Character.isLetter(ch[index])) {
            ch[index] = Character.toUpperCase(ch[index]);
            createPermutations(index + 1, res, ch);
            ch[index] = Character.toLowerCase(ch[index]);
        }
    }
}

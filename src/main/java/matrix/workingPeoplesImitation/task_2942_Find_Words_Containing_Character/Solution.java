package matrix.workingPeoplesImitation.task_2942_Find_Words_Containing_Character;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}

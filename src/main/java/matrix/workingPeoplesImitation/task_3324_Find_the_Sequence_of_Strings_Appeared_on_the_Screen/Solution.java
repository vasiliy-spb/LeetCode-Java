package matrix.workingPeoplesImitation.task_3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// my solution
public class Solution {
    public List<String> stringSequence(String target) {
        int n = target.length();
        List<String> ans = new ArrayList<>();
        char[] letters = new char[n];
        Arrays.fill(letters, (char) ('a' - 1));
        int index = 0;
        while (index < n) {
            while (target.charAt(index) > letters[index]) {
                letters[index] = (char) (letters[index] + 1);
                ans.add(makeStringFromArray(letters, index));
            }
            index++;
        }
        return ans;
    }
    private String makeStringFromArray(char[] letters, int index) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            result.append(letters[i]);
        }
        return result.toString();
    }
}

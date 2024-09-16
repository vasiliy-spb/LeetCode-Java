package matrix.workingPeoplesImitation.task_500_Keyboard_Row;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public String[] findWords(String[] words) {
        List<String> oneRowString = new ArrayList<>();
        for (String word : words) {
            if (isConsistsInOneRow(word)) {
                oneRowString.add(word);
            }
        }
        return oneRowString.toArray(new String[0]);
    }
    private boolean isConsistsInOneRow(String word) {
        String[] rows = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        int countRows = 0;
        for (String row : rows) {
            if (hasFullString(row, word)) {
                countRows++;
            }
        }
        return countRows == 1;
    }
    private boolean hasFullString(String row, String word) {
        for (char ch : word.toCharArray()) {
            if (row.indexOf(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}

package matrix.workingPeoplesImitation.task_6_Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        boolean upToBottom = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (rows[index] == null) rows[index] = new StringBuilder();
            rows[index].append(ch);
            if (upToBottom) {
                index++;
                if (index == numRows) {
                    upToBottom = false;
                    index = numRows - 2;
                }
            } else {
                index--;
                if (index < 0) {
                    upToBottom = true;
                    index = 1;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            if (row != null)
                result.append(row);
        return result.toString();
    }

    // from walkccc.me
    public String convert2(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        List<Character>[] rows = new List[numRows];
        int k = 0;
        int direction = numRows == 1 ? 0 : -1;

        for (int i = 0; i < numRows; ++i)
            rows[i] = new ArrayList<>();

        for (final char c : s.toCharArray()) {
            rows[k].add(c);
            if (k == 0 || k == numRows - 1)
                direction *= -1;
            k += direction;
        }

        for (List<Character> row : rows)
            for (final char c : row)
                sb.append(c);

        return sb.toString();
    }
}

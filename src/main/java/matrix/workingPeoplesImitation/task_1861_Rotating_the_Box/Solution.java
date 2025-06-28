package matrix.workingPeoplesImitation.task_1861_Rotating_the_Box;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    // my solution
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] ans = new char[m][n];
        for (char[] row : ans) {
            Arrays.fill(row, '.');
        }
        for (int r = 0; r < n; r++) {
            char[] row = box[r];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < row.length; i++) {
                char ch = row[i];
                if (ch == '*') {
                    stack.push(i);
                } else if (ch == '#') {
                    stack.push(-1);
                }
            }
            fillColumn(ans, stack, n - 1 - r);
        }
        return ans;
    }
    private void fillColumn(char[][] ans, Stack<Integer> stack, int col) {
        int index = ans.length;
        while (!stack.empty()) {
            int num = stack.pop();
            if (num >= 0) {
                index = num;
                ans[index][col] = '*';
            } else {
                index += num;
                ans[index][col] = '#';
            }
        }
    }

    // from walkccc.me
    public char[][] rotateTheBox2(char[][] box) {
        final int m = box.length;
        final int n = box[0].length;
        char[][] ans = new char[n][m];
        Arrays.stream(ans).forEach(row -> Arrays.fill(row, '.'));

        for (int i = 0; i < m; ++i)
            for (int j = n - 1, k = n - 1; j >= 0; --j)
                if (box[i][j] != '.') {
                    if (box[i][j] == '*')
                        k = j;
                    ans[k--][m - i - 1] = box[i][j];
                }

        return ans;
    }

}

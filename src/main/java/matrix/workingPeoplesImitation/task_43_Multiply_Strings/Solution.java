package matrix.workingPeoplesImitation.task_43_Multiply_Strings;

public class Solution {

    // my solution
    public String multiply(String num1, String num2) {
        String largeString;
        String smallString;
        if (num1.length() > num2.length()) {
            largeString = num1;
            smallString = num2;
        } else {
            largeString = num2;
            smallString = num1;
        }
        StringBuilder[] rows = new StringBuilder[smallString.length()];
        int length = 0;
        for (int i = 0; i < smallString.length(); i++) {
            if (rows[i] == null) rows[i] = new StringBuilder();
            for (int j = 0; j < i; j++) {
                rows[i].append(0);
            }
            int num = Integer.parseInt(String.valueOf(smallString.charAt(smallString.length() - 1 - i)));
            int add = 0;
            for (int j = 0; j < largeString.length(); j++) {
                int currentNum = Integer.parseInt(String.valueOf(largeString.charAt(largeString.length() - 1 - j)));
                int multiply = num * currentNum + add;
                rows[i].insert(0, multiply % 10);
                add = multiply / 10;
            }
            if (add != 0) rows[i].insert(0, add);
            length = Math.max(length, rows[i].length());
        }

        StringBuilder result = new StringBuilder();
        int add = 0;
        for (int i = 0; i < length; i++) {
            int currentNum = add;
            for (StringBuilder row : rows) {
                if (row.length() - 1 - i >= 0) {
                    currentNum += Integer.parseInt(String.valueOf(row.charAt(row.length() - 1 - i)));
                }
            }
            result.insert(0, currentNum % 10);
            add = currentNum / 10;
        }
        if (add != 0) result.insert(0, add);
        int index = -1;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) > '0') break;
            index = i;
        }
        if (index >= 0) result = new StringBuilder(result.substring(index + 1));
        if (result.isEmpty()) return "0";
        return result.toString();
    }

    // from walkccc.me
    public String multiply2(String num1, String num2) {
        final int m = num1.length();
        final int n = num2.length();

        StringBuilder sb = new StringBuilder();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; --i)
            for (int j = n - 1; j >= 0; --j) {
                final int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                final int sum = multiply + pos[i + j + 1];
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }

        for (final int p : pos)
            if (p > 0 || sb.length() > 0)
                sb.append(p);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}

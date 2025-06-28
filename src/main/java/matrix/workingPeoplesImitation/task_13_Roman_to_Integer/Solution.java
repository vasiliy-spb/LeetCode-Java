package matrix.workingPeoplesImitation.task_13_Roman_to_Integer;

public class Solution {

    // my solution
    public int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    count += 4;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    count += 9;
                    i++;
                } else count++;
            } else if (ch == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    count += 40;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    count += 90;
                    i++;
                } else count += 10;
            } else if (ch == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    count += 400;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    count += 900;
                    i++;
                } else count += 100;
            } else if (ch == 'V') count += 5;
            else if (ch == 'L') count += 50;
            else if (ch == 'D') count += 500;
            else if (ch == 'M') count += 1000;
        }
        return count;
    }

    // from walkccc.me
    public int romanToInt2(String s) {
        int ans = 0;
        int[] roman = new int[128];

        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        for (int i = 0; i + 1 < s.length(); ++i)
            if (roman[s.charAt(i)] < roman[s.charAt(i + 1)])
                ans -= roman[s.charAt(i)];
            else
                ans += roman[s.charAt(i)];

        return ans + roman[s.charAt(s.length() - 1)];
    }
}

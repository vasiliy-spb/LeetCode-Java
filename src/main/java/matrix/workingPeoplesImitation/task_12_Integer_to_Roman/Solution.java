package matrix.workingPeoplesImitation.task_12_Integer_to_Roman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    // my solution
    public String intToRoman(int num) {
        TreeMap<Integer, String> charMap = new TreeMap<>(Comparator.reverseOrder());
        charMap.put(1,"I");
        charMap.put(4,"IV");
        charMap.put(5,"V");
        charMap.put(9,"IX");
        charMap.put(10,"X");
        charMap.put(40,"XL");
        charMap.put(50,"L");
        charMap.put(90,"XC");
        charMap.put(100,"C");
        charMap.put(400,"CD");
        charMap.put(500,"D");
        charMap.put(900,"CM");
        charMap.put(1000,"M");
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : charMap.entrySet()) {
            while (num - entry.getKey() >= 0) {
                result.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return result.toString();
    }

    // from walkccc.me (Approach 1: Greedy)
    public String intToRoman2(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M",  "CM", "D",  "CD", "C",  "XC", "L",
                "XL", "X",  "IX", "V",  "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; ++i) {
            if (num == 0)
                break;
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }

    // from walkccc.me (Approach 2: Hash Table)
    public String intToRoman3(int num) {
        final String[] M = {"", "M", "MM", "MMM"};
        final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10];
    }

}

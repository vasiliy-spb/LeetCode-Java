package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;

// from leetcode code sample (5)
public class Solution7 {

    private boolean ableToFindString(String s, int windowSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int j = 0;
        StringBuilder sb = new StringBuilder();

        while (j < s.length()) {
            if (j == 0 || (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(j)))
                sb.append(s.charAt(j));
            else {
                sb = new StringBuilder();
                sb.append(s.charAt(j));
            }

            if (sb.length() > windowSize) {
                sb.deleteCharAt(0);
            }

            if (sb.length() == windowSize) {
                map.put(sb.toString(),
                        map.getOrDefault(sb.toString(), 0) + 1);

                if (map.get(sb.toString()) >= 3)
                    return true;
            }
            j++;
        }
        return false;
    }

    public int maximumLength(String s) {
        int low = 1, high = s.length();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ableToFindString(s, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }

        return (high == 0) ? -1 : high;
    }
}

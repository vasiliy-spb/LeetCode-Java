package matrix.workingPeoplesImitation.task_387_First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // my solution
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        int index = s.length();
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            if (count == 1)
                index = Math.min(index, s.indexOf(i + 'a'));
        }
        return index == s.length() ? -1 : index;
    }

    // my solution
    public int firstUniqChar1(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.merge((int)s.charAt(i), 1, Integer::sum);
        for (int i = 0; i < s.length(); i++) {
            if (map.get((int)s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    // from walkccc.me
    public int firstUniqChar2(String s) {
        int[] count = new int[26];

        for (final char c : s.toCharArray())
            ++count[c - 'a'];

        for (int i = 0; i < s.length(); ++i)
            if (count[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}

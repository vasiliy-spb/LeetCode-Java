package matrix.workingPeoplesImitation.task_2186_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram_II;

import java.util.Arrays;

// my solution
public class Solution {
    public int minSteps(String s, String t) {
        int[] frequency = new int[26];
//        for (char sChar : s.toCharArray()) {
//            frequency[sChar - 'a']++;
//        }
//        for (char tChar : t.toCharArray()) {
//            frequency[tChar - 'a']--;
//        }
        s.chars().forEach(ch -> frequency[ch - 'a']++);
        t.chars().forEach(ch -> frequency[ch - 'a']--);
        return Arrays.stream(frequency).map(Math::abs).sum();
    }
}

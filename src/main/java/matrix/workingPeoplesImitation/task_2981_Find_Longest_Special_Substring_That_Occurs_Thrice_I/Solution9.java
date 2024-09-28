package matrix.workingPeoplesImitation.task_2981_Find_Longest_Special_Substring_That_Occurs_Thrice_I;

import java.util.HashMap;
import java.util.Map;

// from leetcode code sample (7)
public class Solution9 {
    public int maximumLength(String s) {
        Integer maxLen = -1;
        Map<String, Integer> subToOccurences = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i); // a
            for(int j = i ; j < s.length() && c == s.charAt(j) ; j++){
                String sub = s.substring(i, j + 1);
                Integer occurences = subToOccurences.getOrDefault(sub, 0);
                occurences++;
                // System.out.printf("%s -> %s\n", sub, occurences);
                if(occurences >= 3 && sub.length() > maxLen){
                    maxLen = sub.length();
                }
                else{
                    subToOccurences.put(sub, occurences);
                }
            }
        }
        return maxLen;
    }
}

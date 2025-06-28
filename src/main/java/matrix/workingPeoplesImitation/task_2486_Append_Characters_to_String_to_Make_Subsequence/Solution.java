package matrix.workingPeoplesImitation.task_2486_Append_Characters_to_String_to_Make_Subsequence;

public class Solution {
    public int appendCharacters(String s, String t) {
        if (s.contains(t)) return 0;
        StringBuilder prefix = new StringBuilder();
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int currentIndex = s.indexOf(ch, index);
            if (currentIndex >= index) {
                prefix.append(ch);
                index = currentIndex+1;
            } else break;
        }
        return t.length() - prefix.length();
    }
}

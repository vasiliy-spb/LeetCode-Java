package matrix.workingPeoplesImitation.task_2785_Sort_Vowels_in_a_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// from walkccc.me
public class Solution2 {
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        for (final char c : s.toCharArray())
            if (isVowel(c))
                vowels.add(c);

        Collections.sort(vowels);

        int i = 0; // vowels' index
        for (final char c : s.toCharArray())
            sb.append(isVowel(c) ? vowels.get(i++) : c);

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

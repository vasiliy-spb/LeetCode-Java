package matrix.workingPeoplesImitation.task_1935_Maximum_Number_of_Words_You_Can_Type;

import java.util.Arrays;
import java.util.regex.Pattern;

// my solution
public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        brokenLetters += brokenLetters.isEmpty() ? " " : "";
        Pattern p = Pattern.compile("[" + brokenLetters + "]+");
        return (int) Arrays.stream(text.split(" "))
                .filter(word -> !p.matcher(word).find())
                .count();
    }
}

package matrix.workingPeoplesImitation.task_792_Number_of_Matching_Subsequences;

import matrix.workingPeoplesImitation.string_helper.PatternFinder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests {
//    private final Solution testingClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int expected = 3;
        assertEquals(expected, testingClass.numMatchingSubseq(s, words));
    }

    @Test
    public void checkTestcase02() {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        int expected = 2;
        assertEquals(expected, testingClass.numMatchingSubseq(s, words));
    }

    @Test
    public void checkTestcase03() {
        String s = "a".repeat(49950) + "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String[] words = new String[5000];
        for (int i = 0; i < 5000; i++) {
            words[i] = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
        int expected = 5000;
        assertEquals(expected, testingClass.numMatchingSubseq(s, words));
    }

//    public static void main(String[] args) throws IOException {
//        String fileName = "src/main/java/matrix/workingPeoplesImitation/task_792_Number_of_Matching_Subsequences/testcase3.txt";
//        String s = new BufferedReader(new FileReader(fileName)).readLine().trim();
//        s = s.replace("\"", "");
//        PatternFinder.showPattern(s);
//    }
}

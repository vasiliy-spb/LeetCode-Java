package matrix.workingPeoplesImitation.task_3093_Longest_Common_Suffix_Queries;

import matrix.workingPeoplesImitation.string_helper.PatternFinder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] wordsContainer = {"abcd", "bcd", "xbcd"};
        String[] wordsQuery = {"cd", "bcd", "xyz"};
        int[] expected = {1, 1, 1};
        assertArrayEquals(expected, testingClass.stringIndices(wordsContainer, wordsQuery));
    }

    @Test
    public void checkTestcase02() {
        String[] wordsContainer = {"abcdefgh", "poiuygh", "ghghgh"};
        String[] wordsQuery = {"gh", "acbfgh", "acbfegh"};
        int[] expected = {2, 0, 2};
        assertArrayEquals(expected, testingClass.stringIndices(wordsContainer, wordsQuery));
    }

    @Test
    public void checkTestcase03() {
        String[] wordsContainer = {"a".repeat(5000), "ab".repeat(2500), "ac".repeat(2500), "ad".repeat(2500), "ae".repeat(2500), "af".repeat(2500), "ag".repeat(2500), "ah".repeat(2500), "ai".repeat(2500), "aj".repeat(2500), "ba".repeat(2500), "b".repeat(5000), "bc".repeat(2500), "bd".repeat(2500), "be".repeat(2500), "bf".repeat(2500), "bg".repeat(2500), "bh".repeat(2500), "bi".repeat(2500), "bj".repeat(2500), "ca".repeat(2500), "cb".repeat(2500), "c".repeat(5000), "cd".repeat(2500), "ce".repeat(2500), "cf".repeat(2500), "cg".repeat(2500), "ch".repeat(2500), "ci".repeat(2500), "cj".repeat(2500), "da".repeat(2500), "db".repeat(2500), "dc".repeat(2500), "d".repeat(5000), "de".repeat(2500), "df".repeat(2500), "dg".repeat(2500), "dh".repeat(2500), "di".repeat(2500), "dj".repeat(2500), "ea".repeat(2500), "eb".repeat(2500), "ec".repeat(2500), "ed".repeat(2500), "e".repeat(5000), "ef".repeat(2500), "eg".repeat(2500), "eh".repeat(2500), "ei".repeat(2500), "ej".repeat(2500), "fa".repeat(2500), "fb".repeat(2500), "fc".repeat(2500), "fd".repeat(2500), "fe".repeat(2500), "f".repeat(5000), "fg".repeat(2500), "fh".repeat(2500), "fi".repeat(2500), "fj".repeat(2500), "ga".repeat(2500), "gb".repeat(2500), "gc".repeat(2500), "gd".repeat(2500), "ge".repeat(2500), "gf".repeat(2500), "g".repeat(5000), "gh".repeat(2500), "gi".repeat(2500), "gj".repeat(2500), "ha".repeat(2500), "hb".repeat(2500), "hc".repeat(2500), "hd".repeat(2500), "he".repeat(2500), "hf".repeat(2500), "hg".repeat(2500), "h".repeat(5000), "hi".repeat(2500), "hj".repeat(2500), "ia".repeat(2500), "ib".repeat(2500), "ic".repeat(2500), "id".repeat(2500), "ie".repeat(2500), "if".repeat(2500), "ig".repeat(2500), "ih".repeat(2500), "i".repeat(5000), "ij".repeat(2500), "ja".repeat(2500), "jb".repeat(2500), "jc".repeat(2500), "jd".repeat(2500), "je".repeat(2500), "jf".repeat(2500), "jg".repeat(2500), "jh".repeat(2500), "ji".repeat(2500), "j".repeat(5000)};
        String[] wordsQuery = new String[1000];
        Arrays.fill(wordsQuery, "a");
        int[] expected = new int[1000];
        assertArrayEquals(expected, testingClass.stringIndices(wordsContainer, wordsQuery));
    }

    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/matrix/workingPeoplesImitation/task_3093_Longest_Common_Suffix_Queries/testcase3.txt";
//        String fileName = "src/main/java/matrix/workingPeoplesImitation/task_3093_Longest_Common_Suffix_Queries/temp.txt";
//        String template = "ac".repeat(2500);
//        String s = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_3093_Longest_Common_Suffix_Queries/temp.txt")).readLine();
//        System.out.println("template = " + "ac");
//        System.out.println(template.equals(s));

        System.out.println(PatternFinder.getElementsForListAsCodeFromFile(fileName));
    }
}

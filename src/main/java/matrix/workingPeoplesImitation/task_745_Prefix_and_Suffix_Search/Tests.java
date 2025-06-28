package matrix.workingPeoplesImitation.task_745_Prefix_and_Suffix_Search;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void checkTestcase01() {
        WordFilter testingClass = new WordFilter(new String[]{"apple"});
        int expected = 0;
        assertEquals(expected, testingClass.f("a", "e"));
    }

    @Test
    public void checkTestcase02() {
        WordFilter testingClass = new WordFilter(new String[]{"abbba", "abba"});
        int expected = 1;
        assertEquals(expected, testingClass.f("ab", "ba"));
    }

    @Test
    public void checkTestcase03() {
        try {
            String s = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase3_input_init.txt")).readLine();
            s = s.replace("\"", "");
            String[] dictionary = s.split(",");
            WordFilter testingClass = new WordFilter(dictionary);
            BufferedReader requestReader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase3_input_data.txt"));
            BufferedReader expectedReader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase3_expected.txt"));
            int[] expected = Arrays.stream(expectedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            boolean check = true;
            for (int i = 0; i < expected.length; i++) {
                String[] request = requestReader.readLine().replace("\"", "").split(",");
                int ans = testingClass.f(request[0], request[1]);
                check &= expected[i] == ans;
                if (!check) {
                    System.out.println(i + " : Неправильный результат! ------------");
                    System.out.printf("pref = %s; suff = %s; expected = %d, actual = %d", request[0], request[1], expected[i], ans);
                    System.out.println();
                }
            }
            assertTrue(check);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkTestcase04() {
        try {
            String s = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase4_input_init.txt")).readLine();
            s = s.replace("\"", "");
            String[] dictionary = s.split(",");
            WordFilter testingClass = new WordFilter(dictionary);
            BufferedReader requestReader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase4_input_data.txt"));
            BufferedReader expectedReader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_745_Prefix_and_Suffix_Search/testcases/testcase4_expected.txt"));
            int[] expected = Arrays.stream(expectedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            boolean check = true;
            for (int i = 0; i < expected.length; i++) {
                String[] request = requestReader.readLine().replace("\"", "").split(",");
                int ans = testingClass.f(request[0], request[1]);
                check &= expected[i] == ans;
                if (!check) {
                    System.out.println(i + " : Неправильный результат! ------------");
                    System.out.printf("pref = %s; suff = %s; expected = %d, actual = %d", request[0], request[1], expected[i], ans);
                    System.out.println();
                }
            }
            assertTrue(check);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

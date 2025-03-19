package matrix.workingPeoplesImitation.task_2401_Longest_Nice_Subarray;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {1, 3, 8, 48, 10};
        int expected = 3;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {3, 1, 5, 11, 13};
        int expected = 1;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {28, 13, 5, 14, 72, 6, 19};
        int expected = 2;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expected = 2;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {3, 8, 48, 3, 8, 48, 3, 8, 48};
        int expected = 3;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {3, 8, 48};
        int expected = 3;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase07() {
        int[] nums = {84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112, 267703680};
        int expected = 8;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    @Test
    public void checkTestcase08() {
        String filePath = "src/main/java/matrix/workingPeoplesImitation/task_2401_Longest_Nice_Subarray/testcases/testcase08.txt";
        int[] nums = readFromFile(filePath);
        int expected = 20;
        assertEquals(expected, testingClass.longestNiceSubarray(nums));
    }

    private int[] readFromFile(String filePath) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String line = reader.readLine().trim();
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

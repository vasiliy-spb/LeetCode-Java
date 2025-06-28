package matrix.workingPeoplesImitation.task_739_Daily_Temperatures;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, testingClass.dailyTemperatures(temperatures));
    }

    @Test
    public void checkTestcase2() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertArrayEquals(expected, testingClass.dailyTemperatures(temperatures));
    }

    @Test
    public void checkTestcase3() {
        int[] temperatures = {30, 60, 90};
        int[] expected = {1, 1, 0};
        assertArrayEquals(expected, testingClass.dailyTemperatures(temperatures));
    }

    @Test
    public void checkTestcase4() { // 6 / 48 testcases passed
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};
        int[] expected = {8, 1, 5, 4, 3, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, testingClass.dailyTemperatures(temperatures));
    }

    @Test
    public void checkTestcase5() { // 30 / 48 testcases passed
        String temperaturesFile = "src/main/java/matrix/workingPeoplesImitation/task_739_Daily_Temperatures/testcase5a";
        String expectedFile = "src/main/java/matrix/workingPeoplesImitation/task_739_Daily_Temperatures/testcase5expecteda";
        int[] temperatures = readNumbersFromFile(temperaturesFile);
        int[] expected = readNumbersFromFile(expectedFile);
        assertArrayEquals(expected, testingClass.dailyTemperatures(temperatures));
    }

    public static int[] readNumbersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            List<String> numberList = new ArrayList<>();
            while (reader.ready()) {
                String line = reader.readLine();
                numberList.add(line);
            }

            int[] numbers = new int[numberList.size()];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numberList.get(i).trim());
            }

            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
            return new int[0]; // Return an empty array in case of an error
        }
    }

}

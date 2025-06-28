package matrix.workingPeoplesImitation.task_134_Gas_Station;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int expected = 3;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int expected = -1;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase3() {
        int[] gas = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase3gas_split");
        int[] cost = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase3cost_split");
        int expected = 99999;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase4() {
        int[] gas = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase4gas_split");
        int[] cost = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase4cost_split");
        int expected = -1;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase5() {
        int[] gas = {5};
        int[] cost = {4};
        int expected = 0;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase6() {
        int[] gas = {4};
        int[] cost = {5};
        int expected = -1;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    @Test
    public void checkTestcase7() {
        int[] gas = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase7gas_split");
        int[] cost = readNumbersFromFile2("src/main/java/matrix/workingPeoplesImitation/task_134_Gas_Station/testcase7cost_split");
        int expected = 0;
        assertEquals(expected, testingClass.canCompleteCircuit(gas, cost));
    }

    // читает строки чисел из файла и возвращает массив int на их основе
    public static int[] readNumbersFromFile2(String filePath) {
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

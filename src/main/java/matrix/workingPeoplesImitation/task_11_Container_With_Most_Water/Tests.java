package matrix.workingPeoplesImitation.task_11_Container_With_Most_Water;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void testMaxAreaExample1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample2() {
        int[] height = {1, 1};
        int expected = 1;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample3() {
        int[] height = {1,2,4,3};
        int expected = 4;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample4() {
        int[] height = {2,3,4,5,18,17,6};
        int expected = 17;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample5() {
        int[] height = {1,1,1,1,1,2,1,4,3};
        int expected = 8;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample6() {
        int[] height = {76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        int expected = 18048;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExample7() {
        int[] height = {177,112,74,197,90,16,4,61,103,133,198,4,121,143,55,138,47,167,165,159,93,85,53,118,127,171,137,65,135,45,151,64,109,25,61,152,194,65,165,97,199,163,53,72,58,108,10,105,27,127,64,120,164,70,190,91,41,127,109,176,172,12,193,34,38,54,138,184,120,103,33,71,66,86,143,125,146,105,182,173,184,199,46,148,69,36,192,110,116,53,38,40,65,31,74,103,86,12,39,158};
        int expected = 15936;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaExampleTime() {
        String filePath = "src/main/java/matrix/workingPeoplesImitation/task_11_Container_With_Most_Water/testcase5";
        int[] height = readNumbersFromFile(filePath);
        long start = System.currentTimeMillis();
        testingClass.maxArea(height);
        long finish = System.currentTimeMillis();
        assertTrue((finish - start) < 2000);
    }

    @Test
    public void testMaxAreaExampleLarge() {
        String filePath = "src/main/java/matrix/workingPeoplesImitation/task_11_Container_With_Most_Water/testcase5";
        int[] height = readNumbersFromFile(filePath);
        int expected = 721777500;
//        int expected = 721727550;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    public static int[] readNumbersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] numberStrings = line.split(",");

            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }

            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
            return new int[0]; // Return an empty array in case of an error
        }
    }

    @Test
    public void testMaxAreaRandom() {
        int[] height = {3, 9, 3, 4, 7, 2, 12, 6};
        int expected = 45;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaAllZeroes() {
        int[] height = {0, 0, 0, 0, 0};
        int expected = 0;
        int result = testingClass.maxArea(height);
        assertEquals(expected, result);
    }

}

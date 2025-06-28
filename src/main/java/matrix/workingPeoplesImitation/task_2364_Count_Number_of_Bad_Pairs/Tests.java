package matrix.workingPeoplesImitation.task_2364_Count_Number_of_Bad_Pairs;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] nums = {4, 1, 3, 3};
        int expected = 5;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase02() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 0;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase03() {
        int[] nums = {5, 4, 3, 2, 1};
        int expected = 10;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase04() {
        int[] nums = {2, 2, 2, 2, 5, 5, 5, 5};
        int expected = 25;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase05() {
        int[] nums = {5, 5, 5, 5, 2, 2, 2, 2};
        int expected = 28;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase06() {
        int[] nums = {5, 5, 5, 5, 5, 5, 5, 5};
        int expected = 28;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase07() throws IOException { // 43 / 65 testcases passed
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2364_Count_Number_of_Bad_Pairs/testcase07.txt"));
        String[] numStr = reader.readLine().split(",");
        int n = numStr.length; // 8875
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        System.out.println("nums.length = " + nums.length);
        long expected = 39375700;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase08() throws IOException { // 57 / 65 testcases passed
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_2364_Count_Number_of_Bad_Pairs/testcase08.txt"));
        String[] numStr = reader.readLine().split(",");
        int n = numStr.length; // 74847
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
        }
        System.out.println("nums.length = " + nums.length);
        long expected = 2800978228L;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase09() { // 8 / 65 testcases passed
        int[] nums = {1, 2, 2};
        int expected = 2;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase10() {
        int[] nums = {2, 2, 2, 2, 5, 5, 5, 5, 2, 2, 2, 2, 5, 5, 5, 5};
        int expected = 114;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase11() {
        int[] nums = {4, 1, 3, 3, 4, 1, 3, 3, 4, 1, 3, 3};
        int expected = 59;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase12() {
        int[] nums = {4, 1, 3, 3, 4};
        int expected = 7;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase13() {
        int[] nums = {4, 1, 3, 3, 4, 5};
        int expected = 9;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase14() {
        int[] nums = {4, 1, 3, 3, 4, 5, 12};
        int expected = 15;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }

    @Test
    public void checkTestcase15() {
        int[] nums = {4, 1, 3, 3, 4, 5, 12, 7};
        int expected = 18;
        assertEquals(expected, testingClass.countBadPairs(nums));
    }
}

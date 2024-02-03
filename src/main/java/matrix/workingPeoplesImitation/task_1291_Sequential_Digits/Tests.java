package matrix.workingPeoplesImitation.task_1291_Sequential_Digits;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int low = 100;
        int high = 300;
        List<Integer> expected = List.of(123, 234);
        assertEquals(expected, testingClass.sequentialDigits(low, high));
    }

    @Test
    public void checkTestcase2() {
        int low = 1000;
        int high = 13000;
        List<Integer> expected = List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345);
        assertEquals(expected, testingClass.sequentialDigits(low, high));
    }

    @Test
    public void checkTestcase3() {
        int low = 10;
        int high = 1_000_000_000;
        List<Integer> expected = List.of(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789);
        assertEquals(expected, testingClass.sequentialDigits(low, high));
    }

}

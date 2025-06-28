package matrix.workingPeoplesImitation.task_2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int n = 3;
        int[] startPos = {0, 1};
        String s = "RRDDLU";
        int[] expected = {1, 5, 4, 3, 1, 0};
        System.out.println("Expected:");
        System.out.println(Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.executeInstructions(n, startPos, s));
    }

    @Test
    public void checkTestcase02() {
        int n = 2;
        int[] startPos = {1, 1};
        String s = "LURD";
        int[] expected = {4, 1, 0, 0};
        System.out.println("Expected:");
        System.out.println(Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.executeInstructions(n, startPos, s));
    }

    @Test
    public void checkTestcase03() {
        int n = 1;
        int[] startPos = {0, 0};
        String s = "LRUD";
        int[] expected = {0, 0, 0, 0};
        System.out.println("Expected:");
        System.out.println(Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.executeInstructions(n, startPos, s));
    }
}

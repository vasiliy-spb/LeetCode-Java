package matrix.workingPeoplesImitation.task_1652_Defuse_the_Bomb;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] expected = {12, 10, 16, 13};
        assertArrayEquals(expected, testingClass.decrypt(code, k));
    }

    @Test
    public void checkTestcase02() {
        int[] code = {1, 2, 3, 4};
        int k = 0;
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, testingClass.decrypt(code, k));
    }

    @Test
    public void checkTestcase03() {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] expected = {12, 5, 6, 13};
        System.out.println("code" + Arrays.toString(code));
        System.out.println("expected" + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.decrypt(code, k));
    }

    @Test
    public void checkTestcase04() {
        int[] code = {10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6};
        int k = -4;
        int[] expected = {22, 26, 22, 28, 29, 22, 19, 22, 18, 21, 28, 19};
        System.out.println("code" + Arrays.toString(code));
        System.out.println("expected" + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.decrypt(code, k));
    }
}

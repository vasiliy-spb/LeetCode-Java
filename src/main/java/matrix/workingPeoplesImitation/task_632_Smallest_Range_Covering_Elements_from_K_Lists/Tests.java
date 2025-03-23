package matrix.workingPeoplesImitation.task_632_Smallest_Range_Covering_Elements_from_K_Lists;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        List<List<Integer>> nums = List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30));
        int[] expected = {20, 24};
        int[] ans = testingClass.smallestRange(nums);
        System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected));
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.out.println();
        assertArrayEquals(expected, ans);
    }

    @Test
    public void checkTestcase02() {
        List<List<Integer>> nums = List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3));
        int[] expected = {1, 1};
        int[] ans = testingClass.smallestRange(nums);
        System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected));
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.out.println();
        assertArrayEquals(expected, ans);
    }

    @Test
    public void checkTestcase03() {
        List<List<Integer>> nums = List.of(List.of(1, 2, 3), List.of(2, 3, 4), List.of(3, 4, 5));
        int[] expected = {3, 3};
        int[] ans = testingClass.smallestRange(nums);
        System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected));
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.out.println();
        assertArrayEquals(expected, ans);
    }

    @Test
    public void checkTestcase04() {
        List<List<Integer>> nums = List.of(List.of(1, 2, 3), List.of(0, 3, 5), List.of(2, 3, 4));
        int[] expected = {3, 3};
        int[] ans = testingClass.smallestRange(nums);
        System.out.println("Arrays.toString(expected) = " + Arrays.toString(expected));
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.out.println();
        assertArrayEquals(expected, ans);
    }
}

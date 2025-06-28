package matrix.workingPeoplesImitation.task_399_Evaluate_Division;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        double[] expected = {6.0, 0.5, -1.0, 1.0, -1.0};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase2() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values = {1.5, 2.5, 5.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"), List.of("cd", "bc"));
        double[] expected = {3.75000, 0.40000, 5.00000, 0.20000};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase3() {
        List<List<String>> equations = List.of(List.of("a", "b"));
        double[] values = {0.5};
        List<List<String>> queries = List.of(List.of("a", "b"), List.of("b", "a"), List.of("a", "c"), List.of("x", "y"));
        double[] expected = {0.50000, 2.00000, -1.00000, -1.00000};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase4() { // 5 / 28 testcases passed
        List<List<String>> equations = List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x3", "x4"), List.of("x4", "x5"));
        double[] values = {3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = List.of(List.of("x1", "x5"), List.of("x5", "x2"), List.of("x2", "x4"), List.of("x2", "x2"), List.of("x2", "x9"), List.of("x9", "x9"));
        double[] expected = {360.0, 0.008333333333333333, 20.0, 1.0, -1.0, -1.0};
//        double[] expected = {360.00000, 0.00833, 20.00000, 1.00000, -1.00000, -1.00000}; // в оригинальном тесте ожидаемый результат такой
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase5() { // 19 / 28 testcases passed
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("c", "d"));
        double[] values = {1.0, 1.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "d"), List.of("b", "a"), List.of("d", "c"));
        double[] expected = {-1.00000, -1.00000, 1.00000, 1.00000};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase6() { // 20 / 28 testcases passed
        List<List<String>> equations = List.of(List.of("x1", "x2"), List.of("x2", "x3"), List.of("x1", "x4"), List.of("x2", "x5"));
        double[] values = {3.0, 0.5, 3.4, 5.6};
        List<List<String>> queries = List.of(List.of("x2", "x4"), List.of("x1", "x5"), List.of("x1", "x3"), List.of("x5", "x5"), List.of("x5", "x1"), List.of("x3", "x4"), List.of("x4", "x3"), List.of("x6", "x6"), List.of("x0", "x0"));
        double[] expected = {1.1333333333333333, 16.799999999999997, 1.5, 1.0, 0.05952380952380953, 2.2666666666666666, 0.4411764705882353, -1.0, -1.0};
//        double[] expected = {1.13333, 16.80000, 1.50000, 1.00000, 0.05952, 2.26667, 0.44118, -1.00000, -1.00000};  // в оригинальном тесте ожидаемый результат такой
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

    @Test
    public void checkTestcase7() {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("c", "d"), List.of("e", "f"), List.of("g", "h"));
        double[] values = {4.5, 2.3, 8.9, 0.44};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("d", "f"), List.of("h", "e"), List.of("b", "e"), List.of("d", "h"), List.of("g", "f"), List.of("c", "g"));
        double[] expected = {-1.00000, -1.00000, -1.00000, -1.00000, -1.00000, -1.00000, -1.00000};
        System.out.println("expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, testingClass.calcEquation(equations, values, queries), 0);
    }

}

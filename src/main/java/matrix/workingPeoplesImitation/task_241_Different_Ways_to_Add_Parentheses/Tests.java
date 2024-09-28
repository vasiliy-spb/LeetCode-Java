package matrix.workingPeoplesImitation.task_241_Different_Ways_to_Add_Parentheses;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    //    private final Solution testingClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String expression = "2-1-1";
        List<Integer> expected = new ArrayList<>(List.of(0, 2));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
        String expression = "2*3-4*5";
        List<Integer> expected = new ArrayList<>(List.of(-34, -14, -10, -10, 10));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase03() {
        String expression = "9-9-9-9-9-9-9-9-9-12";
        List<Integer> expected = new ArrayList<>();
        try {
            String[] expectedNums = new BufferedReader(new FileReader("src/main/java/matrix/workingPeoplesImitation/task_241_Different_Ways_to_Add_Parentheses/testcase3_expected.txt")).readLine().split(",");
            for (String num : expectedNums) {
                expected.add(Integer.parseInt(num));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase04() {
        String expression = "0";
        List<Integer> expected = new ArrayList<>(List.of(0));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase05() {
        String expression = "15+7-6*24";
        List<Integer> expected = new ArrayList<>(List.of(-122, 39, -122, 384, 384));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase06() {
        String expression = "5+7-6*2";
        List<Integer> expected = new ArrayList<>(List.of(0, 7, 0, 12, 12));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase07() {
        String expression = "2-1-1-1-1";
        List<Integer> expected = new ArrayList<>(List.of(2, 0, 2, 2, 4, 0, 2, 2, 0, 0, 2, 0, 0, -2));
        List<Integer> result = testingClass.diffWaysToCompute(expression);
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }
}

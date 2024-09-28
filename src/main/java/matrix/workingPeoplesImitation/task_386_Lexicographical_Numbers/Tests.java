package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution templateClass = new Solution();
    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int n = 13;
        List<Integer> expected = List.of(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9);
        expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase02() {
        int n = 2;
        List<Integer> expected = List.of(1,2);
        expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase03() {
        int n = 100;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase04() {
        int n = 1000;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase05() {
        int n = 50000;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase06() {
        int n = 144;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase07() {
        int n = 80;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase08() {
        int n = 10;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase09() {
        int n = 90;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcase10() {
        int n = 190;
        List<Integer> expected = templateClass.lexicalOrder(n);
        assertEquals(expected, testingClass.lexicalOrder(n));
    }

    @Test
    public void checkTestcaseFullDiapason() {
        for (int i = 1; i <= 50000; i++) {
//            System.out.println(i);
            List<Integer> expected = templateClass.lexicalOrder(i);
            assertEquals(expected, testingClass.lexicalOrder(i));
        }
    }


}

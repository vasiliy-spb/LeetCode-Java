package matrix.workingPeoplesImitation.task_273_Integer_to_English_Words;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int num = 123;
        String expected = "One Hundred Twenty Three";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
        int num = 12345;
        String expected = "Twelve Thousand Three Hundred Forty Five";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase03() {
        int num = 1234567;
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase04() {
        int num = Integer.MAX_VALUE;
        String expected = "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase05() {
        int num = 2_000_483_647;
        String expected = "Two Billion Four Hundred Eighty Three Thousand Six Hundred Forty Seven";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase06() {
        int num = 3;
        String expected = "Three";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase07() {
        int num = 2_000_000_647;
        String expected = "Two Billion Six Hundred Forty Seven";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase08() {
        int num = 2_000_000_000;
        String expected = "Two Billion";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase09() {
        int num = 2_000_000_001;
        String expected = "Two Billion One";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase10() {
        int num = 2_000_001_000;
        String expected = "Two Billion One Thousand";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase11() { // 528 / 601 testcases passed
        int num = 0;
        String expected = "Zero";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase12() { // 529 / 601 testcases passed
        int num = 101;
        String expected = "One Hundred One";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase13() { // 590 / 601 testcases passed
        int num = 100000;
        String expected = "One Hundred Thousand";
        String result = testingClass.numberToWords(num);
        System.out.println("expected = " + expected);
        System.out.println("result = " + result);
        assertEquals(expected, result);
    }
}

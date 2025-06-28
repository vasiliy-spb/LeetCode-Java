package matrix.workingPeoplesImitation.task_3035_Maximum_Palindromes_After_Operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String[] words = {"abbb", "ba", "aa"};
        int expected = 3;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase2() {
        String[] words = {"abc", "ab"};
        int expected = 2;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase3() {
        String[] words = {"cd", "ef", "a"};
        int expected = 1;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase4() { // 135 / 507 testcases passed
        String[] words = {"aa", "bc"};
        int expected = 1;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase5() { // 263 / 507 testcases passed
        String[] words = {"a", "a", "caa"};
        int expected = 3;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase6() { // 506 / 507 testcases passed
        String[] words = {"nulr", "owdyq", "ycjof", "td", "fzuz", "avzi", "pkmb", "odpx", "efcv", "vx", "qo", "c"};
        int expected = 8;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase7() { // 498 / 507 testcases passed
        String[] words = {"dba", "g"};
        int expected = 1;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase8() { // 443 / 507 testcases passed
        String[] words = {"aed", "cgfd"};
        int expected = 1;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase9() { // 444 / 507 testcases passed
        String[] words = {"egf","aaaeh","eehce","dhbgg"};
        int expected = 3;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

    @Test
    public void checkTestcase10() { // 443 / 507 testcases passed
        String[] words = {"bc","ac","cc"};
        int expected = 2;
        assertEquals(expected, testingClass.maxPalindromesAfterOperations(words));
    }

}

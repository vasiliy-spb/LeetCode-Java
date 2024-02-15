package matrix.workingPeoplesImitation.task_22_Generate_Parentheses;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int n = 3;
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expected, testingClass.generateParenthesis(n));
    }

    @Test
    public void checkTestcase2() {
        int n = 1;
        List<String> expected = List.of("()");
        assertEquals(expected, testingClass.generateParenthesis(n));
    }

}

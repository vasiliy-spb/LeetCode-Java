package matrix.workingPeoplesImitation.task_1106_Parsing_A_Boolean_Expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String expression = "&(|(f))";
        assertFalse(testingClass.parseBoolExpr(expression));
    }

    @Test
    public void checkTestcase02() {
        String expression = "|(f,f,f,t)";
        assertTrue(testingClass.parseBoolExpr(expression));
    }

    @Test
    public void checkTestcase03() {
        String expression = "!(&(f,t))";
        assertTrue(testingClass.parseBoolExpr(expression));
    }
}

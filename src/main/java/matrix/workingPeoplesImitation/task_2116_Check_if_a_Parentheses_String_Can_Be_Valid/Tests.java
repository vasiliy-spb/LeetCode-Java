package matrix.workingPeoplesImitation.task_2116_Check_if_a_Parentheses_String_Can_Be_Valid;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String s = "))()))";
        String locked = "010100";
        assertTrue(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase2() {
        String s = "()()";
        String locked = "0000";
        assertTrue(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase3() {
        String s = ")";
        String locked = "0";
        assertFalse(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase4() { // 70 / 258 testcases passed
        String s = ")";
        String locked = "1";
        assertFalse(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase5() { // 72 / 258 testcases passed
        String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
        String locked = "100011110110011011010111100111011101111110000101001101001111";
        assertFalse(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase6() { // 197 / 258 testcases passed
        String s = "))()))";
        String locked = "010100";
        assertTrue(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase7() { // 7 / 258 testcases passed
        String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
        String locked = "100011110110011011010111100111011101111110000101001101001111";
        assertFalse(testingClass.canBeValid(s, locked));
    }

    @Test
    public void checkTestcase8() { // 203 / 258 testcases passed
        String s = "())()))()(()(((())(()()))))((((()())(())";
        String locked = "1011101100010001001011000000110010100101";
        assertTrue(testingClass.canBeValid(s, locked));
    }

}

// checkTestcase8
// ( ) ) ( ) ) ) ( ) ( ( ) ( ( ( ( ) ) ( ( ) ( ) ) ) ) ) ( ( ( ( ( ) ( ) ) ( ( ) )
// 1 0 1 1 1 0 1 1 0 0 0 1 0 0 0 1 0 0 1 0 1 1 0 0 0 0 0 0 1 1 0 0 1 0 1 0 0 1 0 1


// checkTestcase8
// ( ) ) ( ) ) ) ( ) ( ( ) ( ( ( ( ) ) ( ( ) ( ) ) ) ) ) ( ( ( ( ( ) ( ) ) ( ( ) )
// 1 0 1 1 1 0 1 1 0 0 0 1 0 0 0 1 0 0 1 0 1 1 0 0 0 0 0 0 1 1 0 0 1 0 1 0 0 1 0 1
// ( _ ) ( ) _ ) ( _ _ _ ) _ _ _ ( _ _ ( _ ) ( _ _ _ _ _ _ ( ( _ _ ) _ ) _ _ ( _ )



// _ ) ( ) _ ) ( _ _ _ ) _ _ _ ( _ _ ( _ ) ( _ _ _ _ _ _ ( ( _ _ ) _ ) _ _ ( _




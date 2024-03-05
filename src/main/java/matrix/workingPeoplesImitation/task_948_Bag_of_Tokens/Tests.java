package matrix.workingPeoplesImitation.task_948_Bag_of_Tokens;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] tokens = {100};
        int power = 50;
        int expected = 0;
        assertEquals(expected, testingClass.bagOfTokensScore(tokens, power));
    }

    @Test
    public void checkTestcase2() {
        int[] tokens = {200,100};
        int power = 150;
        int expected = 1;
        assertEquals(expected, testingClass.bagOfTokensScore(tokens, power));
    }

    @Test
    public void checkTestcase3() {
        int[] tokens = {100,200,300,400};
        int power = 200;
        int expected = 2;
        assertEquals(expected, testingClass.bagOfTokensScore(tokens, power));
    }

    @Test
    public void checkTestcase4() { // 3 / 147 testcases passed
        int[] tokens = {};
        int power = 85;
        int expected = 0;
        assertEquals(expected, testingClass.bagOfTokensScore(tokens, power));
    }

}

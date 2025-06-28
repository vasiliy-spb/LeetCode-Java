package matrix.workingPeoplesImitation.task_649_Dota2_Senate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String senate = "RD";
        String expected = "Radiant";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

    @Test
    public void checkTestcase2() {
        String senate = "RDD";
        String expected = "Dire";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

    @Test
    public void checkTestcase3() { // 62 / 82 testcases passed
        String senate = "DDRRR";
        String expected = "Dire";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

    @Test
    public void checkTestcase4() { // 79 / 82 testcases passed
        String senate = "RRDRDDRDRRDDDDDRDRDR";
        String expected = "Radiant";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

    @Test
    public void checkTestcase5() { // 5 / 82 testcases passed
        String senate = "RRR";
        String expected = "Radiant";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

    @Test
    public void checkTestcase6() { // 80 / 82 testcases passed
        String senate = "DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR";
        String expected = "Dire";
        assertEquals(expected, testingClass.predictPartyVictory(senate));
    }

}

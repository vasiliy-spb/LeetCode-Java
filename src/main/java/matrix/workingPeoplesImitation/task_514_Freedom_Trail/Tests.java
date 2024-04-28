package matrix.workingPeoplesImitation.task_514_Freedom_Trail;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String ring = "godding";
        String key = "gd";
        int expected = 4;
        assertEquals(expected, testingClass.findRotateSteps(ring, key));
    }

    @Test
    public void checkTestcase02() {
        String ring = "godding";
        String key = "godding";
        int expected = 13;
        assertEquals(expected, testingClass.findRotateSteps(ring, key));
    }

    @Test
    public void checkTestcase03() {
        String ring = "oddingg";
        String key = "godding";
        int expected = 14;
        assertEquals(expected, testingClass.findRotateSteps(ring, key));
    }

    @Test
    public void checkTestcase04() { // 48 / 303 testcases passed
        String ring = "xrrakuulnczywjs";
        String key = "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr";
        int expected = 204;
        assertEquals(expected, testingClass.findRotateSteps(ring, key));
    }

    @Test
    public void checkTestcase05() { // 48 / 303 testcases passed
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        int expected = 137;
        assertEquals(expected, testingClass.findRotateSteps(ring, key));
    }
}

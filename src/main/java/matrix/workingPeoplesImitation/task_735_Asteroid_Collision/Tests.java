package matrix.workingPeoplesImitation.task_735_Asteroid_Collision;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] asteroids = {5, 10, -5};
        int[] expected = {5, 10};
        assertArrayEquals(expected, testingClass.asteroidCollision(asteroids));
    }

    @Test
    public void checkTestcase2() {
        int[] asteroids = {8, -8};
        int[] expected = {};
        assertArrayEquals(expected, testingClass.asteroidCollision(asteroids));
    }

    @Test
    public void checkTestcase3() {
        int[] asteroids = {10, 2, -5};
        int[] expected = {10};
        assertArrayEquals(expected, testingClass.asteroidCollision(asteroids));
    }

    @Test
    public void checkTestcase4() {
        int[] asteroids = {10, 2, -5, -3, -9};
        int[] expected = {10};
        assertArrayEquals(expected, testingClass.asteroidCollision(asteroids));
    }

    @Test
    public void checkTestcase5() { // 143 / 275 testcases passed
        int[] asteroids = {-2, -1, 1, 2};
        int[] expected = {-2, -1, 1, 2};
        assertArrayEquals(expected, testingClass.asteroidCollision(asteroids));
    }

}

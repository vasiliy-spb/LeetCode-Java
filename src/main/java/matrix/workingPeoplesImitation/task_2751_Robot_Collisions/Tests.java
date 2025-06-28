package matrix.workingPeoplesImitation.task_2751_Robot_Collisions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        int[] positions = {5, 4, 3, 2, 1};
        int[] healths = {2, 17, 9, 15, 10};
        String directions = "RRRRR";
        List<Integer> expected = List.of(2, 17, 9, 15, 10);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase02() {
        int[] positions = {3, 5, 2, 6};
        int[] healths = {10, 10, 15, 12};
        String directions = "RLRL";
        List<Integer> expected = List.of(14);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase03() {
        int[] positions = {1, 2, 5, 6};
        int[] healths = {10, 10, 11, 11};
        String directions = "RLRL";
        List<Integer> expected = List.of();
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase04() {
        int[] positions = {1, 40};
        int[] healths = {10, 11};
        String directions = "RL";
        List<Integer> expected = List.of(10);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase05() {
        int[] positions = {11, 44, 16};
        int[] healths = {1, 20, 17};
        String directions = "RLR";
        List<Integer> expected = List.of(18);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase06() {
        int[] positions = {17, 24, 18};
        int[] healths = {1, 39, 30};
        String directions = "LLR";
        List<Integer> expected = List.of(1, 38);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }

    @Test
    public void checkTestcase07() {
        int[] positions = {42, 3, 46, 2};
        int[] healths = {13, 8, 34, 37};
        String directions = "LRLR";
        List<Integer> expected = List.of(35);
        assertEquals(expected, testingClass.survivedRobotsHealths(positions, healths, directions));
    }
}

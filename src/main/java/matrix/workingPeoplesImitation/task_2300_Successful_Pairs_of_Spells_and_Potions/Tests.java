package matrix.workingPeoplesImitation.task_2300_Successful_Pairs_of_Spells_and_Potions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;
        int[] expected = {4, 0, 3};
        assertArrayEquals(expected, testingClass.successfulPairs(spells, potions, success));
    }

    @Test
    public void checkTestcase2() {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        int success = 16;
        int[] expected = {2, 0, 2};
        assertArrayEquals(expected, testingClass.successfulPairs(spells, potions, success));
    }

}

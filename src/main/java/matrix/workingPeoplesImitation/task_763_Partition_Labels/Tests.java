package matrix.workingPeoplesImitation.task_763_Partition_Labels;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> expected = List.of(9, 7, 8);
        assertEquals(expected, testingClass.partitionLabels(s));
    }

    @Test
    public void checkTestcase02() {
        String s = "eccbbbbdec";
        List<Integer> expected = List.of(10);
        assertEquals(expected, testingClass.partitionLabels(s));
    }

    @Test
    public void checkTestcase03() {
        String s = "vhaagbqkaq";
        List<Integer> expected = List.of(1, 1, 8);
        assertEquals(expected, testingClass.partitionLabels(s));
    }

    @Test
    public void checkTestcase04() {
        String s = "eaaaabaaec";
        List<Integer> expected = List.of(9, 1);
        assertEquals(expected, testingClass.partitionLabels(s));
    }
}

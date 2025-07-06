package matrix.workingPeoplesImitation.task_1943_Describe_the_Painting;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTests {
    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        int[][] segments = {{1, 4, 5}, {4, 7, 7}, {1, 7, 9}};
        List<List<Long>> expected = List.of(
                List.of(1L, 4L, 14L),
                List.of(4L, 7L, 16L)
        );
        assertEquals(expected, testingClass.splitPainting(segments));
    }

    @Test
    public void checkTestcase02() {
        int[][] segments = {{1, 7, 9}, {6, 8, 15}, {8, 10, 7}};
        List<List<Long>> expected = List.of(
                List.of(1L, 6L, 9L),
                List.of(6L, 7L, 24L),
                List.of(7L, 8L, 15L),
                List.of(8L, 10L, 7L)
        );
        assertEquals(expected, testingClass.splitPainting(segments));
    }

    @Test
    public void checkTestcase03() {
        int[][] segments = {{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}};
        List<List<Long>> expected = List.of(
                List.of(1L, 4L, 12L),
                List.of(4L, 7L, 12L)
        );
        assertEquals(expected, testingClass.splitPainting(segments));
    }

    @Test
    public void checkTestcase04() {
        int[][] segments = {
                {4, 5, 9}, {8, 12, 5}, {4, 7, 19}, {14, 15, 1},
                {3, 10, 8}, {17, 20, 18}, {7, 19, 14}, {8, 16, 6},
                {14, 17, 7}, {11, 13, 3}
        };

        List<List<Long>> expected = List.of(
                List.of(3L, 4L, 8L),
                List.of(4L, 5L, 36L),
                List.of(5L, 7L, 27L),
                List.of(7L, 8L, 22L),
                List.of(8L, 10L, 33L),
                List.of(10L, 11L, 25L),
                List.of(11L, 12L, 28L),
                List.of(12L, 13L, 23L),
                List.of(13L, 14L, 20L),
                List.of(14L, 15L, 28L),
                List.of(15L, 16L, 27L),
                List.of(16L, 17L, 21L),
                List.of(17L, 19L, 32L),
                List.of(19L, 20L, 18L)
        );

        assertEquals(expected, testingClass.splitPainting(segments));
    }

    @Test
    public void checkTestcase05() {
        int[][] segments = {
                {4, 16, 12}, {9, 10, 15}, {18, 19, 13},
                {3, 13, 20}, {12, 16, 3}, {2, 10, 10},
                {3, 11, 4}, {13, 16, 6}
        };

        List<List<Long>> expected = List.of(
                List.of(2L, 3L, 10L),
                List.of(3L, 4L, 34L),
                List.of(4L, 9L, 46L),
                List.of(9L, 10L, 61L),
                List.of(10L, 11L, 36L),
                List.of(11L, 12L, 32L),
                List.of(12L, 13L, 35L),
                List.of(13L, 16L, 21L),
                List.of(18L, 19L, 13L)
        );

        assertEquals(expected, testingClass.splitPainting(segments));
    }
}

package matrix.workingPeoplesImitation.task_692_Top_K_Frequent_Words;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> expected = List.of("i", "love");
        assertEquals(expected, testingClass.topKFrequent(words, k));
    }

    @Test
    public void checkTestcase2() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> expected = List.of("the", "is", "sunny", "day");
        assertEquals(expected, testingClass.topKFrequent(words, k));
    }

}

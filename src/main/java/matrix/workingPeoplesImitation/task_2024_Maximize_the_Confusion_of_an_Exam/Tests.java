package matrix.workingPeoplesImitation.task_2024_Maximize_the_Confusion_of_an_Exam;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String answerKey = "TTFF";
        int k = 2;
        int expected = 4;
        assertEquals(expected, testingClass.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    public void checkTestcase02() {
        String answerKey = "TFFT";
        int k = 1;
        int expected = 3;
        assertEquals(expected, testingClass.maxConsecutiveAnswers(answerKey, k));
    }

    @Test
    public void checkTestcase03() {
        String answerKey = "TTFTTFTT";
        int k = 1;
        int expected = 5;
        assertEquals(expected, testingClass.maxConsecutiveAnswers(answerKey, k));
    }
}

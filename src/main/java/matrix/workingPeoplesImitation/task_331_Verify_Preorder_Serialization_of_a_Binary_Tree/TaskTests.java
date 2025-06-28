package matrix.workingPeoplesImitation.task_331_Verify_Preorder_Serialization_of_a_Binary_Tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        assertTrue(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase02() {
        String preorder = "1,#";
        assertFalse(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase03() {
        String preorder = "9,#,#,1";
        assertFalse(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase04() {
        String preorder = "#";
        assertTrue(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase05() {
        String preorder = "1";
        assertFalse(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase06() {
        String preorder = "#,#,#";
        assertFalse(testingClass.isValidSerialization(preorder));
    }

    @Test
    public void checkTestcase07() {
        String preorder = "9,#,93,#,9,9,#,#,#";
        assertTrue(testingClass.isValidSerialization(preorder));
    }
}

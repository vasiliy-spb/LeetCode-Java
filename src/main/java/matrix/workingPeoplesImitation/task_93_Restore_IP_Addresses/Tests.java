package matrix.workingPeoplesImitation.task_93_Restore_IP_Addresses;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String s = "25525511135";
        Set<String> expected = Set.of("255.255.11.135", "255.255.111.35");
        List<String> resultList = testingClass.restoreIpAddresses(s);
        assertEquals(expected, new HashSet<>(resultList));
    }

    @Test
    public void checkTestcase02() {
        String s = "0000";
        Set<String> expected = Set.of("0.0.0.0");
        List<String> resultList = testingClass.restoreIpAddresses(s);
        assertEquals(expected, new HashSet<>(resultList));
    }

    @Test
    public void checkTestcase03() {
        String s = "101023";
        Set<String> expected = Set.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        List<String> resultList = testingClass.restoreIpAddresses(s);
        assertEquals(expected, new HashSet<>(resultList));
    }

    @Test
    public void checkTestcase04() {
        String s = "00000";
        Set<String> expected = Set.of();
        List<String> resultList = testingClass.restoreIpAddresses(s);
        assertEquals(expected, new HashSet<>(resultList));
    }
}

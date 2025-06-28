package matrix.workingPeoplesImitation.task_1233_Remove_Sub_Folders_from_the_Filesystem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase01() {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> expected = new ArrayList<>(List.of("/a", "/c/d", "/c/f"));
        List<String> result = new ArrayList<>(testingClass.removeSubfolders(folder));
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase02() {
        String[] folder = {"/a", "/a/b/c", "/a/b/d"};
        List<String> expected = new ArrayList<>(List.of("/a"));
        List<String> result = new ArrayList<>(testingClass.removeSubfolders(folder));
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase03() {
        String[] folder = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        List<String> expected = new ArrayList<>(List.of("/a/b/c", "/a/b/ca", "/a/b/d"));
        List<String> result = new ArrayList<>(testingClass.removeSubfolders(folder));
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }

    @Test
    public void checkTestcase04() {
        String[] folder = {"/a", "/c", "/d"};
        List<String> expected = new ArrayList<>(List.of("/a", "/c", "/d"));
        List<String> result = new ArrayList<>(testingClass.removeSubfolders(folder));
        expected.sort(Comparator.naturalOrder());
        result.sort(Comparator.naturalOrder());
        assertEquals(expected, result);
    }
}

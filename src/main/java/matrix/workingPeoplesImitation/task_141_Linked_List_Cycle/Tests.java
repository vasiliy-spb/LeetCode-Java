package matrix.workingPeoplesImitation.task_141_Linked_List_Cycle;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] input = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = createLinkedList(input, pos);
        boolean expected = true;
        assertTrue(testingClass.hasCycle(head));
    }

    @Test
    public void checkTestcase2() {
        Integer[] input = {1, 2};
        int pos = 0;
        ListNode head = createLinkedList(input, pos);
        boolean expected = true;
        assertTrue(testingClass.hasCycle(head));
    }

    @Test
    public void checkTestcase3() {
        Integer[] input = {1};
        int pos = -1;
        ListNode head = createLinkedList(input, pos);
        boolean expected = false;
        assertFalse(testingClass.hasCycle(head));
    }

    @Test
    public void checkTestcase4() {
        Integer[] input = {1, 2};
        int pos = -1;
        ListNode head = createLinkedList(input, pos);
        boolean expected = false;
        assertFalse(testingClass.hasCycle(head));
    }

    @Test
    public void checkTestcase5() {
        Integer[] input = readIntegersFromFile("src/main/java/matrix/workingPeoplesImitation/task_141_Linked_List_Cycle/testcase5_split");
        int pos = -1;
        ListNode head = createLinkedList(input, pos);
        boolean expected = false;
        assertFalse(testingClass.hasCycle(head));

    }

    // В методе createLinkedList создается связный список на основе входного массива input и параметра pos.
    // Если pos равно -1, то связный список создается без цикла.
    // В противном случае последний элемент связного списка ссылается на узел с индексом pos в массиве input.
    public ListNode createLinkedList(Integer[] input, int pos) {
        if (input == null || input.length == 0) {
            return null;
        }

        ListNode[] nodes = new ListNode[input.length];
        for (int i = 0; i < input.length; i++) {
            nodes[i] = new ListNode(input[i]);
        }

        for (int i = 0; i < input.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        if (pos != -1 && pos < input.length) {
            nodes[input.length - 1].next = nodes[pos];
        }

        return nodes[0];
    }

    // читает строки чисел из файла и возвращает массив Integer на их основе
    public static Integer[] readIntegersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] numberStrings = line.split(",");

            Integer[] numbers = new Integer[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                if (numberStrings[i].equals("null")) numbers[i] = null;
                else numbers[i] = Integer.parseInt(numberStrings[i].trim());
            }

            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
            return new Integer[0]; // Return an empty array in case of an error
        }
    }

}

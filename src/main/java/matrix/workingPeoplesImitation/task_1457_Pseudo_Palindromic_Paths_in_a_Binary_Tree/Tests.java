package matrix.workingPeoplesImitation.task_1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        Integer[] input = {2, 3, 1, 3, 1, null, 1};
        TreeNode root = buildTreeFromArray(input);
        int expected = 2;
        assertEquals(expected, testingClass.pseudoPalindromicPaths(root));
    }

    @Test
    public void checkTestcase2() {
        Integer[] input = {2, 1, 1, 1, 3, null, null, null, null, null, 1};
        TreeNode root = buildTreeFromArray(input);
        int expected = 1;
        assertEquals(expected, testingClass.pseudoPalindromicPaths(root));
    }

    @Test
    public void checkTestcase3() {
        Integer[] input = {9};
        TreeNode root = buildTreeFromArray(input);
        int expected = 1;
        assertEquals(expected, testingClass.pseudoPalindromicPaths(root));
    }

    @Test
    public void checkTestcase4() { // 53 / 56 testcases passed
        String path = "src/main/java/matrix/workingPeoplesImitation/task_1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree/Testcase4";
        Integer[] input = readIntegersFromFile(path);
        TreeNode root = buildTreeFromArray(input);
        int expected = 50000;
        assertEquals(expected, testingClass.pseudoPalindromicPaths(root));
    }

    @Test
    public void checkTestcase5() { // 25 / 56 testcases passed
        Integer[] input = {8, 8, null, 7, 7, null, null, 2, 4, null, 8, null, 7, null, 1};
        TreeNode root = buildTreeFromArray(input);
        int expected = 2;
        assertEquals(expected, testingClass.pseudoPalindromicPaths(root));
    }

    /*
                                                8,
                                        8,              null,
                              7,                  7,
                        null,   null,     2,             4,
                                     null,  8,       null, 7,
                                        null, 1

     */

    // собирает дерево из массива (если в массиве пропущены потомки нулевых (null) элементов)
    public static TreeNode buildTreeFromArray(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);

        for (int i = 1; i < array.length; i++) {
            TreeNode current = queue.poll();

            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }

            i++;

            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
        }

        return root;
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

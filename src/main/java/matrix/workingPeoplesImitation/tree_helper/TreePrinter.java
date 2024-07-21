package matrix.workingPeoplesImitation.tree_helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {

    /*
    Заменим Integer.MIN_VALUE на null.
Тогда правильный вывод в консоль для дерева :
[4, 2, 7, null, 1, null, 3, 6, null, null, 5, 9, null, 12]
должен быть:
[4]
[2, 7]
[null, 1, null, 3]
[null, null, 6, null, null, null, null, 5]
[null, null, null, null, 9, null, null, null, null, null, null, null, null, null, 12, null]
[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]
Измени код, чтобы он выдавал нужный результат
     */
    public static List<List<Integer>> getLevels(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }

        queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && depth > 0) {
            System.out.println("-");
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.val != Integer.MIN_VALUE) {
                    currentLevel.add(node.val);
                    if (node.left == null) queue.add(new TreeNode(Integer.MIN_VALUE));
                    else queue.add(node.left);
                    if (node.right == null) queue.add(new TreeNode(Integer.MIN_VALUE));
                    else queue.add(node.right);
                } else {
                    currentLevel.add(null);
                    queue.add(new TreeNode(Integer.MIN_VALUE));  // Add two null children for each null node
                    queue.add(new TreeNode(Integer.MIN_VALUE));
                }
            }

            levels.add(currentLevel);
            depth--;
        }

        return levels;
    }

    // Напиши метод, который принимает на вход корень дерева, а возвращает List<List<Integer>> levels, который содержит значения узлов дерева по уровням.
    // levels.get(0) содержит корень
    // levels.get(1) содержит потомки корня
    // levels.get(2) содержит потомки корней из levels.get(1)
    // и тд.
    // при этом, каждый список должен состоять из такого количества элементов, как если бы дерево было полным и сбалансированным.
    // На месте каждого узла, отсутствующего во входящем дереве пусть лежит значение Integer.MIN_VALUE;
    //
    // Method to get the levels of the tree
//    public static List<List<Integer>> getLevels1(TreeNode root) {
//        List<List<Integer>> levels = new ArrayList<>();
//        if (root == null) {
//            return levels;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            List<Integer> currentLevel = new ArrayList<>(levelSize);
//
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.poll();
//                if (node != null) {
//                    currentLevel.add(node.val);
//                    queue.add(node.left);
//                    queue.add(node.right);
//                } else {
//                    currentLevel.add(null);
//                }
//            }
//
//            levels.add(currentLevel);
//        }
//
//        return levels;
//    }

    // Method to visualize a binary tree from its levels
    public static void visualizeTree(List<List<Integer>> levels) {
        int maxLevel = levels.size();
        int maxLength = calculateMaxLength(levels);

        for (int i = 0; i < maxLevel; i++) {
            int levelSize = levels.get(i).size();
            int spacesBetweenNodes = maxLength / (levelSize + 1);
            int nodesPrinted = 0;

            for (int j = 0; j < levelSize; j++) {
                Integer value = levels.get(i).get(j);

                if (value != null) {
                    int nodeLength = String.valueOf(value).length();
                    int padding = spacesBetweenNodes + 1;
                    System.out.print(String.format("%" + (padding + nodesPrinted + nodeLength) + "s", value));
                    nodesPrinted = nodeLength;
                } else {
                    System.out.print(String.format("%" + (spacesBetweenNodes + 1) + "s", "-"));
                    nodesPrinted = 1;
                }

                if (j < levelSize - 1) {
                    for (int k = 0; k < spacesBetweenNodes; k++) {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();

            if (i < maxLevel - 1) {
                printConnectingLines(levels, i, spacesBetweenNodes);
            }
        }
    }

    // Helper method to print connecting lines between nodes
    private static void printConnectingLines(List<List<Integer>> levels, int currentLevel, int spacesBetweenNodes) {
        int nextLevelSize = levels.get(currentLevel + 1).size();

        for (int i = 0; i < nextLevelSize; i++) {
            System.out.print(String.format("%-" + (spacesBetweenNodes + 1) + "s", ""));
            System.out.print("/");
            for (int j = 0; j < spacesBetweenNodes - 1; j++) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    // Helper method to calculate the maximum length needed for each node's string representation
    private static int calculateMaxLength(List<List<Integer>> levels) {
        int maxVal = 0;
        for (List<Integer> level : levels) {
            for (Integer value : level) {
                if (value != null) {
                    maxVal = Math.max(maxVal, String.valueOf(value).length());
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {

        Integer[] input = {4, 2, 7, null, 1, null, 3, 6, null, null, 5, 9, null, 12};
        TreeNode root = BinaryTreeTestHelper.buildTreeFromArray(input);

        // Get the levels of the tree
        List<List<Integer>> levels = getLevels(root);

        // Print the levels
        for (List<Integer> level : levels) {
            System.out.println(level);
        }

        visualizeTree(levels);
    }

    public static void printTree(TreeNode root) {
        List<List<Integer>> levels = getLevels(root);

        // Print the levels
        for (List<Integer> level : levels) {
            System.out.println(level);
        }

        visualizeTree(levels);
    }

}

/*
Now write a method that takes as input List<List<Integer>> levels, which represents the values of the binary tree nodes by level
The method must calculate the required distance between characters and values, and output strings to the console so that a symbolic visualization of a binary tree is obtained.
For example, for lists:

[4]
[2, 7]
[null, 1, null, 3]
[null, null, 6, null, null, null, null, 5]
[null, null, null, null, 9, null, null, null, null, null, null, null, null, null, 12, null]

The console output should be:

                                                 4
                          /                                             \
                         2                                               7
              /                     \                         /                     \
             -                       1                       -                       3
        /         \             /         \             /         \             /         \
       -           -           6           -           -           -           -           3
     /   \       /   \       /   \       /   \       /   \       /   \       /   \       /   \
    -     -     -     -     9     -     -     -     -     -     -     -     -     -     12    -
 */

/*
Теперь напиши метод, который на вход принимает List<List<Integer>> levels, в котором представлены значения узлов бинарного дерева по уровням
Метод должен рассчитать нужное расстояние между символами и значениями, и выводить строки в консоль так, чтобы получилась символьная визуализация бинарного дерева.
Например, для списков :
[4]
[2, 7]
[null, 1, null, 3]
[null, null, 6, null, null, null, null, 5]
[null, null, null, null, 9, null, null, null, null, null, null, null, null, null, 12, null]
Вывод в консоль должен быть:
                                                 4
                          /                                             \
                         2                                               7
              /                     \                         /                     \
             -                       1                       -                       3
        /         \             /         \             /         \             /         \
       -           -           6           -           -           -           -           3
     /   \       /   \       /   \       /   \       /   \       /   \       /   \       /   \
    -     -     -     -     9     -     -     -     -     -     -     -     -     -     12    -

 */

/*
Теперь напиши метод, который на вход принимает List<List<Integer>> levels, в котором представлены значения узлов бинарного дерева по уровням
Метод должен рассчитать нужное расстояние между символами и значениями, и выводить строки в консоль так, чтобы получилась символьная визуализация бинарного дерева.
Например, для списков :
[4]
[2, 7]
[null, 1, null, 3]
[6, null, null, 5]
[9, null, 12, null]
[null, null, null, null]
Вывод в консоль должен быть в таком виде:


   9   -  12   -
 */


/*
[4]
[2, 7]
[null, 1, null, 3]
[null, null, 6, null, null, null, null, 5]
[null, null, null, null, 9, null, null, null, null, null, null, null, null, null, 12, null]
[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]

[4]
[2, 7]
[null, 1, null, 3]
[null, null, 6, null, null, null, null, 5]
[null, null, null, null, 9, null, null, null, null, null, null, null, null, null, 12, null]

[4]
[2, 7]
[null, 1, null, 3]
[6, null, null, 5]
[9, null, 12, null]

                 4
          /            \
         2                 7
        / \               /         \
       -       1          -          3
     / \      / \       /   \        /   \
    -   -    6   -     -    -       -     3
   / \ / \  / \ / \   / \   / \    / \   / \
           9   -     -   - -   -  -   - 12   -

начало дерева

                                                 4
                          /                                             \
                         2                                               7
              /                     \                         /                     \
             -                       1                       -                       3
        /         \             /         \             /         \             /         \
       -           -           6           -           -           -           -           3
     /   \       /   \       /   \       /   \       /   \       /   \       /   \       /   \
    -     -     -     -     9     -     -     -     -     -     -     -     -     -     12    -
   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \
  -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   -

 */

/*

                                                 -
                          /                                             \
                         -                                               -
              /                     \                         /                     \
             -                       -                       -                       -
        /         \             /         \             /         \             /         \
       -           -           -           -           -           -           -           -
     /   \       /   \       /   \       /   \       /   \       /   \       /   \       /   \
    -     -     -     -     -     -     -     -     -     -     -     -     -     -     -     -
   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \   / \
  -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   - -   -
 */
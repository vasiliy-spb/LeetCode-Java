package matrix.workingPeoplesImitation.task_113_Path_Sum_II;

import java.util.*;

public class Solution {

    // my solution
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        List<TreeNode> leafs = new ArrayList<>();
        parents.put(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sumMap.merge(current, current.val, Integer::sum);

            if (sumMap.get(current) == targetSum && current.left == null && current.right == null) leafs.add(current);

            if (current.left != null) {
                queue.offer(current.left);
                sumMap.merge(current.left, sumMap.get(current), Integer::sum);
                parents.put(current.left, current);
            }

            if (current.right != null) {
                queue.offer(current.right);
                sumMap.merge(current.right, sumMap.get(current), Integer::sum);
                parents.put(current.right, current);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeNode leaf : leafs) {
            List<Integer> path = new ArrayList<>();
            TreeNode current = leaf;
            while (current != null) {
                path.add(0, current.val);
                current = parents.get(current);
            }
            result.add(path);
        }
        return result;
    }

    // from walkccc.me (комментарии на русском сделаны GPT)
    // Главный метод для поиска путей в бинарном дереве с заданной суммой
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        // Список для хранения результатов путей
        List<List<Integer>> ans = new ArrayList<>();
        // Вспомогательная функция для поиска в глубину
        dfs(root, sum, new ArrayList<>(), ans);
        // Возвращаем окончательный список путей
        return ans;
    }

    // Вспомогательный метод для поиска в глубину
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        // Базовый случай: если текущий узел равен null, возвращаемся
        if (root == null)
            return;

        // Если текущий узел является листовым и его значение совпадает с оставшейся суммой
        if (root.val == sum && root.left == null && root.right == null) {
            // Добавляем текущее значение в путь
            path.add(root.val);
            // Добавляем текущий путь в список результатов
            ans.add(new ArrayList<>(path));
            // Удаляем последний элемент для возврата и исследования других путей
            path.remove(path.size() - 1);
            return;
        }

        // Добавляем текущее значение в путь
        path.add(root.val);
        // Рекурсивно исследуем левое поддерево с оставшейся суммой
        dfs(root.left, sum - root.val, path, ans);
        // Рекурсивно исследуем правое поддерево с оставшейся суммой
        dfs(root.right, sum - root.val, path, ans);
        // Удаляем последний элемент для возврата и исследования других путей
        path.remove(path.size() - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
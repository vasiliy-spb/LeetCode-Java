package matrix.workingPeoplesImitation.task_199_Binary_Tree_Right_Side_View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // my solution (BFS)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (i == levelSize - 1) result.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return result;
    }

    // from walkccc.me (Approach 2: DFS)
    //
    // Основная идея этого алгоритма:
    // 1. На каждой глубине дерева выберите только один узел.
    // 2. Глубина просмотра — это текущий размер списка результатов.
    //
    // with comments from GPT
    // Основной метод для получения видимости с правой стороны бинарного дерева
    public List<Integer> rightSideView2(TreeNode root) {
        // Инициализация списка результатов для хранения значений с правой стороны
        List<Integer> ans = new ArrayList<>();
        // Вызов метода поиска в глубину (DFS) для обхода дерева
        dfs(root, 0, ans);
        // Возврат окончательного результата
        return ans;
    }

    // Метод поиска в глубину (DFS) для обхода бинарного дерева
    private void dfs(TreeNode root, int depth, List<Integer> ans) {
        // Базовый случай: если текущий узел равен null, возвращаемся
        if (root == null)
            return;

        // Проверка, равна ли текущая глубина размеру списка результатов
        // Если да, это означает, что мы достигли нового уровня, и виден крайний правый узел на этом уровне
        if (depth == ans.size())
            ans.add(root.val);

        // Рекурсивно обходим сначала правое поддерево, затем левое поддерево
        // Это гарантирует, что мы всегда посещаем крайний правый узел на каждом уровне первым
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
    // Из комментариев с leetcode
    // Аккуратный алгоритм... Просто хочу добавить 3 пункта:
    //(1) обход дерева НЕ является стандартным обходом предварительного заказа. Сначала проверяется ПРАВЫЙ узел, а затем ЛЕВЫЙ.
    //(2) строка для проверки currDepth == result.size() гарантирует, что первый элемент этого уровня будет добавлен в список результатов.
    //(3) если изменить порядок посещения, то есть сначала ВЛЕВО, а затем ВПРАВО, будет возвращен левый вид дерева.

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
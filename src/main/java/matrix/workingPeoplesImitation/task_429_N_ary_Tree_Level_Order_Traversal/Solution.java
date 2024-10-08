package matrix.workingPeoplesImitation.task_429_N_ary_Tree_Level_Order_Traversal;

import matrix.workingPeoplesImitation.tree_helper.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                list.add(current.val);
                for (Node node : current.children) {
                    queue.offer(node);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

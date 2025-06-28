package matrix.workingPeoplesImitation.task_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.*;

// from walkccc.me
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>(Arrays.asList(root));
        boolean isLeftToRight = true;

        while (!dq.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            for (int sz = dq.size(); sz > 0; --sz)
                if (isLeftToRight) {
                    TreeNode node = dq.pollFirst();
                    currLevel.add(node.val);
                    if (node.left != null)
                        dq.addLast(node.left);
                    if (node.right != null)
                        dq.addLast(node.right);
                } else {
                    TreeNode node = dq.pollLast();
                    currLevel.add(node.val);
                    if (node.right != null)
                        dq.addFirst(node.right);
                    if (node.left != null)
                        dq.addFirst(node.left);
                }
            ans.add(currLevel);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }
}

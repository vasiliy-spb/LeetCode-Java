package matrix.workingPeoplesImitation.task_100_Same_Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    // my solution
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Queue<TreeNode> queueP = new ArrayDeque<>();
        queueP.offer(p);
        Queue<TreeNode> queueQ = new ArrayDeque<>();
        queueQ.offer(q);
        while (!queueP.isEmpty() || !queueQ.isEmpty()) {
            if (queueP.isEmpty() || queueQ.isEmpty()) return false;
            TreeNode currentP = queueP.poll();
            TreeNode currentQ = queueQ.poll();
            if (currentP.val != currentQ.val) return false;
            if (currentP.left != null) {
                if (currentQ.left == null) return false;
                queueP.offer(currentP.left);
            }
            if (currentP.right != null) {
                if (currentQ.right == null) return false;
                queueP.offer(currentP.right);
            }
            if (currentQ.left != null) {
                if (currentP.left == null) return false;
                queueQ.offer(currentQ.left);
            }
            if (currentQ.right != null) {
                if (currentP.right == null) return false;
                queueQ.offer(currentQ.right);
            }
        }
        return true;
    }

    // from walkccc.me
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val &&          //
                isSameTree2(p.left, q.left) && //
                isSameTree2(p.right, q.right);
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
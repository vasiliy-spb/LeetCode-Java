package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (2)
public class Solution7 {
    public int countDash(int j, String traversal) {
        int dem = 0;
        while (j >= 0 && traversal.charAt(j) == '-') {
            dem++;
            j--;
        }
        return dem;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        int demDash = 0;
        List<Integer> level = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < traversal.length(); i++) {
            if (traversal.charAt(i) != '-') {
                level.add(countDash(i - 1, traversal));
                int numStart = i;
                while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                    i++;
                }
                nodes.add(new TreeNode(Integer.parseInt(traversal.substring(numStart, i))));
            }
        }
        for (int i = 1; i < nodes.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (level.get(j) < level.get(i)) {
                    nodes.get(j).add(nodes.get(i));
                    break;
                }
            }
        }

        return nodes.get(0);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void add(TreeNode newNode) {
            if (this.left == null) {
                this.left = newNode;
            } else this.right = newNode;
        }
    }
}

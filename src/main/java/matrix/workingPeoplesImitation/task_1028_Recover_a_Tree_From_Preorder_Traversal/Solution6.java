package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from leetcode code sample (1)
public class Solution6 {
    private String s;
    private int idx, level;

    public TreeNode recoverFromPreorder(final String traversal) {
        this.s = traversal;
        this.idx = 0;
        this.level = 0;

        TreeNode node = new TreeNode(-1);

        this.helper(node, 0);

        return node.left;
    }

    private void helper(final TreeNode parent, final int lvl) {
        while (this.idx < this.s.length() && lvl == level) {
            int num = 0;

            // Get value
            while (this.idx < this.s.length() && Character.isDigit(this.s.charAt(this.idx))) {
                num *= 10;
                num += this.s.charAt(this.idx++) - '0';
            }

            // Add child
            final TreeNode node = new TreeNode(num);

            if (parent.left == null)
                parent.left = node;
            else
                parent.right = node;

            this.level = 0;

            // Get next level
            while (this.idx < this.s.length() && this.s.charAt(this.idx) == '-') {
                this.level++;
                this.idx++;
            }

            this.helper(node, lvl + 1);
        }
    }
}

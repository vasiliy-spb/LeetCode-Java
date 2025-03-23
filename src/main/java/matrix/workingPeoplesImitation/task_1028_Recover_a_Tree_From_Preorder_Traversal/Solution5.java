package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

// from walkccc.me
public class Solution5 {
    public TreeNode recoverFromPreorder(String traversal) {
        return recoverFromPreorder(traversal, 0);
    }

    private int i = 0;

    private TreeNode recoverFromPreorder(final String traversal, int depth) {
        int nDashes = 0;
        while (i + nDashes < traversal.length() && traversal.charAt(i + nDashes) == '-')
            ++nDashes;
        if (nDashes != depth)
            return null;

        i += depth;
        final int start = i;
        while (i < traversal.length() && Character.isDigit(traversal.charAt(i)))
            ++i;

        return new TreeNode(Integer.valueOf(traversal.substring(start, i)),
                recoverFromPreorder(traversal, depth + 1),
                recoverFromPreorder(traversal, depth + 1));
    }
}

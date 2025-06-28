package matrix.workingPeoplesImitation.task_331_Verify_Preorder_Serialization_of_a_Binary_Tree;

// from walkccc.me
public class Solution2 {
    public boolean isValidSerialization(String preorder) {
        int degree = 1; // out-degree (children) - in-degree (parent)

        for (final String node : preorder.split(",")) {
            if (--degree < 0) // One parent
                return false;
            if (!node.equals("#"))
                degree += 2; // Two children
        }

        return degree == 0;
    }
}

package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

// my solution
public class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();

        int index = 0;
        int num = 0;
        int digit = traversal.charAt(index) - '0';
        while (index < traversal.length() && digit >= 0 && digit <= 9) {
            num *= 10;
            num += digit;
            index++;
            if (index < traversal.length()) {
                digit = traversal.charAt(index) - '0';
            }
        }

        TreeNode root = new TreeNode(num);
        parentsMap.put(root, null);
        int parentLevel = 0;

        if (index == traversal.length()) {
            return root;
        }

        int level = parentLevel;
        char ch = traversal.charAt(index);
        while (index < traversal.length() && ch == '-') {
            level++;
            index++;
            ch = traversal.charAt(index);
        }

        TreeNode current = root;
        while (level == parentLevel + 1 && index < traversal.length()) {
            num = 0;
            digit = traversal.charAt(index) - '0';
            while (index < traversal.length() && digit >= 0 && digit <= 9) {
                num *= 10;
                num += digit;
                index++;
                if (index < traversal.length()) {
                    digit = traversal.charAt(index) - '0';
                }
            }
            if (current.left == null) {
                current.left = new TreeNode(num);
                parentsMap.put(current.left, current);
                current = current.left;
            } else {
                current.right = new TreeNode(num);
                parentsMap.put(current.right, current);
                current = current.right;
            }
            parentLevel = level;
            level = 0;
            if (index < traversal.length()) {
                ch = traversal.charAt(index);
            }
            while (index < traversal.length() && ch == '-') {
                level++;
                index++;
                if (index < traversal.length()) {
                    ch = traversal.charAt(index);
                }
            }

            while (level <= parentLevel) {
                current = parentsMap.get(current);
                parentLevel--;
            }
        }
        return root;
    }
}

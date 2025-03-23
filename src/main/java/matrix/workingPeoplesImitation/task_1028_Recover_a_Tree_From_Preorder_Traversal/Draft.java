package matrix.workingPeoplesImitation.task_1028_Recover_a_Tree_From_Preorder_Traversal;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

public class Draft {
    public TreeNode recoverFromPreorder(String traversal) {
        int index = 0;
        int num = 0;
        int digit = traversal.charAt(index) - '0';
        while (index < traversal.length() && digit >= 0 && digit <= 9) {
            digit = traversal.charAt(index) - '0';
            num *= 10;
            num += digit;
            index++;
        }
        TreeNode root = new TreeNode(num);
        int level = 0;
        char ch = traversal.charAt(index);
        while (index < traversal.length() && ch == '-') {
            ch = traversal.charAt(index);
            level++;
            index++;
        }
        recover(root, index, level, traversal);

        return root;
    }

    private int[] recover(TreeNode parent, int index, int currentLevel, String traversal) {
//        int level = 0;
//        char ch = traversal.charAt(index);
//        while (index < traversal.length() && ch == '-') {
//            ch = traversal.charAt(index);
//            level++;
//            index++;
//        }

        if (index == traversal.length()) {
            return null;
        }

        int num = 0;
        int digit = traversal.charAt(index) - '0';
        while (index < traversal.length() && digit >= 0 && digit <= 9) {
            digit = traversal.charAt(index) - '0';
            num *= 10;
            num += digit;
            index++;
        }

        if (index == traversal.length()) {
            if (parent.left == null) {
                parent.left = new TreeNode(num);
            } else {
                parent.right = new TreeNode(num);
            }
            return null;
        }

        int nextLevel = currentLevel;
        char currentCh = traversal.charAt(index);
        while (index < traversal.length() && currentCh == '-') {
            currentCh = traversal.charAt(index);
            nextLevel++;
            index++;
        }

        int[] levelIndexArr = null;
        if (parent.left == null) {
            parent.left = new TreeNode(num);
            if (nextLevel > currentLevel) {
                levelIndexArr = recover(parent.left, index, nextLevel, traversal);
            } else {
                levelIndexArr = new int[]{nextLevel, index};
            }
        } else {
            parent.right = new TreeNode(num);
            if (nextLevel > currentLevel) {
                levelIndexArr = recover(parent.right, index, nextLevel, traversal);
            } else {
                levelIndexArr = new int[]{nextLevel, index};
            }
        }

        if (levelIndexArr != null) {
            currentLevel = levelIndexArr[0];
            index = levelIndexArr[1];

            num = 0;
            digit = traversal.charAt(index) - '0';
            while (index < traversal.length() && digit >= 0 && digit <= 9) {
                digit = traversal.charAt(index) - '0';
                num *= 10;
                num += digit;
                index++;
            }

            nextLevel = currentLevel;
            currentCh = traversal.charAt(index);
            while (index < traversal.length() && currentCh == '-') {
                currentCh = traversal.charAt(index);
                nextLevel++;
                index++;
            }
        }
        return null;
    }


//    public TreeNode recoverFromPreorder1(String traversal) {
//        int index = 0;
//        int num = 0;
//        int digit = traversal.charAt(index) - '0';
//        while (index < traversal.length() && digit >= 0 && digit <= 9) {
//            digit = traversal.charAt(index) - '0';
//            num *= 10;
//            num += digit;
//            index++;
//        }
//        TreeNode root = new TreeNode(num);
//
//        int parentLevel = 0;
//        TreeNode current = root;
//
//        int level = 0;
//        char ch = traversal.charAt(index);
//        while (index < traversal.length() && ch == '-') {
//            ch = traversal.charAt(index);
//            level++;
//            index++;
//        }
//        num = 0;
//        digit = traversal.charAt(index) - '0';
//        while (index < traversal.length() && digit >= 0 && digit <= 9) {
//            digit = traversal.charAt(index) - '0';
//            num *= 10;
//            num += digit;
//            index++;
//        }
//
//        while (level == parentLevel + 1) {
//            if (current.left == null) {
//                current.left = new TreeNode(num);
//            } else {
//                current.right = new TreeNode(num);
//            }
//            parentLevel++;
//
//            level = 0;
//            ch = traversal.charAt(index);
//            while (index < traversal.length() && ch == '-') {
//                ch = traversal.charAt(index);
//                level++;
//                index++;
//            }
//            num = 0;
//            digit = traversal.charAt(index) - '0';
//            while (index < traversal.length() && digit >= 0 && digit <= 9) {
//                digit = traversal.charAt(index) - '0';
//                num *= 10;
//                num += digit;
//                index++;
//            }
//        }
//
//
//        recoveryTree(root, index, 0, traversal);
//        return root;
//    }
//
//    public TreeNode recoverFromPreorder0(String traversal) {
//        int index = 0;
//        int num = 0;
//        int digit = traversal.charAt(index) - '0';
//        while (digit >= 0 && digit <= 9) {
//            num *= 10;
//            num += digit;
//            index++;
//            digit = traversal.charAt(index) - '0';
//        }
//        TreeNode root = new TreeNode(num);
//        recoveryTree(root, index, 0, traversal);
//        return root;
//    }
//
//    private int recoveryTree(TreeNode parent, int index, int parentLevel, String traversal) {
//        if (index == traversal.length()) {
//            return parentLevel;
//        }
//        int level = 0;
//        char ch = traversal.charAt(index);
//        while (index < traversal.length() && ch == '-') {
//            ch = traversal.charAt(index);
//            level++;
//            index++;
//        }
//        int num = 0;
//        int digit = traversal.charAt(index) - '0';
//        while (index < traversal.length() && digit >= 0 && digit <= 9) {
//            digit = traversal.charAt(index) - '0';
//            num *= 10;
//            num += digit;
//            index++;
//        }
//        if (level == parentLevel + 1) {
//            if (parent.left == null) {
//                parent.left = new TreeNode(num);
//                return recoveryTree(parent.left, index, level, traversal);
//            } else {
//                parent.right = new TreeNode(num);
//                return recoveryTree(parent.right, index, level, traversal);
//            }
//        } else {
//            return level;
//        }
//    }
}

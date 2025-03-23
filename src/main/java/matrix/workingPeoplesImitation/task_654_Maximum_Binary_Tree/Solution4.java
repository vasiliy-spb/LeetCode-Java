package matrix.workingPeoplesImitation.task_654_Maximum_Binary_Tree;

import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

// from leetcode solutions (https://leetcode.com/problems/maximum-binary-tree/solutions/1072835/two-solution-with-detail-explain-by-gcl2-5ge8/) from (https://leetcode.com/u/gcl272633743/)
public class Solution4 {
    /*
     Solution: use monotonic decrease stack
        if current num is less than peek num in stack link current num to right child
        of peek elememnt in stack

        while current num is greater than peek num in stack
           link current node left child to peek num in stack

        3   stack 3              tree: 3
        2   stack 3 2            tree: 3
                                        \
                                         2
        1   stack 3 2 1          tree: 3
                                        \
                                         2
                                          \
                                           1
        6: a)
            stack 3 2            tree: 3
                                        \
                                         2   6
                                          \ /
                                           1
           stack 3               tree:
                                       3   6
                                        \ /
                                         2
                                          \
                                           1
          stack ''               tree: 6
                                      /
                                     3
                                      \
                                       2
                                        \
                                         1
          stack 6

        5: stack 6 5             tree: 6
                                      / \
                                     3   5
                                      \
                                       2
                                        \
                                         1

       0: stack 6 5 0           tree:   6
                                     /    \
                                    3      5
                                     \    /
                                      2  0
                                       \
                                        1

     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int n : nums) {
            TreeNode cur = new TreeNode(n);
            while (!stack.isEmpty() && stack.peek().val < n) {
                cur.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}

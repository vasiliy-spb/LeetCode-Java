package matrix.workingPeoplesImitation.task_1367_Linked_List_in_Binary_Tree;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;
import matrix.workingPeoplesImitation.tree_helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

// from leetcode editorial (Approach 3: Knuth-Morris-Pratt (KMP) Algorithm)
public class Solution4 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        // Build the pattern and prefix table from the linked list
        List<Integer> pattern = new ArrayList<>();
        List<Integer> prefixTable = new ArrayList<>();
        pattern.add(head.val);
        prefixTable.add(0);
        int patternIndex = 0;
        head = head.next;

        while (head != null) {
            while (patternIndex > 0 && head.val != pattern.get(patternIndex)) {
                patternIndex = prefixTable.get(patternIndex - 1);
            }
            patternIndex += head.val == pattern.get(patternIndex) ? 1 : 0;
            pattern.add(head.val);
            prefixTable.add(patternIndex);
            head = head.next;
        }

        // Perform DFS to search for the pattern in the tree
        return searchInTree(root, 0, pattern, prefixTable);
    }

    private boolean searchInTree(
            TreeNode node,
            int patternIndex,
            List<Integer> pattern,
            List<Integer> prefixTable
    ) {
        if (node == null) return false;

        while (patternIndex > 0 && node.val != pattern.get(patternIndex)) {
            patternIndex = prefixTable.get(patternIndex - 1);
        }
        patternIndex += node.val == pattern.get(patternIndex) ? 1 : 0;

        // Check if the pattern is fully matched
        if (patternIndex == pattern.size()) return true;

        // Recursively search left and right subtrees
        return (
                searchInTree(node.left, patternIndex, pattern, prefixTable) ||
                        searchInTree(node.right, patternIndex, pattern, prefixTable)
        );
    }
}
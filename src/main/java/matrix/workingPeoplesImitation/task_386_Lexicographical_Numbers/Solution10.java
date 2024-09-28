package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (4)
public class Solution10 {
    public List<Integer> lexicalOrder(int n) {
        TrieNode root = new TrieNode();
        for (int i = 1; i <= n; i++) {
            insert(root, i);
        }
        List<Integer> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void insert(TrieNode node, int number) {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length(); i++) {
            int index = numberString.charAt(i) - '0';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isLast = true;
    }

    public void traverse(TrieNode root, int current, List<Integer> result) {
        if (root.isLast) {
            result.add(current);
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                int next = current * 10 + i;
                traverse(root.children[i], next, result);
            }
        }
    }

    static class TrieNode {
        public boolean isLast;
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[10];
        }
    }

}

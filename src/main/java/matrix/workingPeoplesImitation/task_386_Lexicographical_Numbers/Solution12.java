package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (6)
public class Solution12 {
    public List<Integer> lexicalOrder(int n) {
        TrieNode root = new TrieNode();
        List<Integer> result = new ArrayList();

        for (int i = 1; i <= n; i++) {
            insert(root, i);
        }

        getOrder(root, 0, result);
        return result;
    }

    public void insert(TrieNode root, int num) {
        TrieNode node = root;
        int digits = (int) Math.log10(num) + 1;
        int multiplier = (int) Math.pow(10, digits - 1);

        while (multiplier > 0) {
            int rem = (num / multiplier) % 10;
            if (!node.contains(rem)) {
                node.put(rem, new TrieNode());
            }
            node = node.getChildren(rem);
            multiplier /= 10;
        }
        node.setEnd();
    }

    public void getOrder(TrieNode root, int s, List<Integer> list) {
        TrieNode node = root;

        if (node.isEnd()) {
            list.add(s);
        }
        for (int i = 0; i <= 9; i++) {
            if (node.contains(i)) {
                s = s * 10 + i;
                getOrder(node.getChildren(i), s, list);
                s = s / 10;
            }
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[10];
        boolean isEnd = false;

        public TrieNode getChildren(int ch) {
            return children[ch];
        }

        public void put(int ch, TrieNode node) {
            children[ch] = node;
        }

        public boolean contains(int ch) {
            return children[ch] != null;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}

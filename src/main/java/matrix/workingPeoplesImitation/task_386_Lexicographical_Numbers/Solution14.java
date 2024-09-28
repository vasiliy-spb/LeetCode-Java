package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (8)
public class Solution14 {
    // trie node
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.isEnd = false;
            children = new TrieNode[10];
        }

    }

    void insert(TrieNode root, int val) {
        TrieNode curr = root;
        String num = String.valueOf(val);
        for (char c : num.toCharArray()) {
            int idx = c - '0';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    void dfs(TrieNode root, List<Integer> res, StringBuilder curr) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (root.children[i] != null) {
                curr.append(i);
                res.add(Integer.parseInt(curr.toString()));
                dfs(root.children[i], res, curr);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }


    public List<Integer> lexicalOrder(int n) {
        TrieNode root = new TrieNode();
        for (int i = 1; i <= n; i++) {
            insert(root, i);
        }
        List<Integer> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        dfs(root, res, curr);
        return res;
    }
}

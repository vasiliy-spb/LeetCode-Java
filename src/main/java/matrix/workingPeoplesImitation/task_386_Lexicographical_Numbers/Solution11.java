package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (5)
public class Solution11 {
    static class TrieDigit {
        TrieDigit[] children = new TrieDigit[10];
    }

    public void add(TrieDigit root, String s) {
        for (var c : s.toCharArray()) {
            if (root.children[c - '0'] == null) {
                root.children[c - '0'] = new TrieDigit();
            }
            root = root.children[c - '0'];
        }
    }

    public void outputTrie(TrieDigit root, List<Integer> res, int num) {
        if (root == null) {
            return;
        }
        if (num > 0) {
            res.add(num);
        }
        for (int i = 0; i <= 9; i++) {
            outputTrie(root.children[i], res, num * 10 + i);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        var root = new TrieDigit();
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i);
            add(root, s);
        }
        List<Integer> res = new ArrayList<>();
        outputTrie(root, res, 0);
        return res;
    }
}

package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (7)
public class Solution13 {
    public void dfs(List<Integer> ls, Trie root, int prv) {
        for (int i = 0; i < 10; i++) {
            if (root.arr[i] != null) {
                ls.add(prv * 10 + i);
                dfs(ls, root.arr[i], prv * 10 + i);
            }
        }
    }

    public List<Integer> lexicalOrder(int n) {
        Trie root = new Trie();
        for (int i = 1; i <= n; i++) {
            String s = i + "";
            int idx = 0;
            Trie temp = root;
            while (idx < s.length()) {
                char ch = s.charAt(idx);
                if (temp.arr[ch - '0'] == null) temp = temp.insert(ch);
                else temp = temp.arr[ch - '0'];
                idx++;
            }
        }
        List<Integer> ls = new ArrayList<>();
        dfs(ls, root, 0);
        return ls;


    }

    static class Trie {
        Trie[] arr = new Trie[10];

        public Trie insert(char ch) {
            arr[ch - '0'] = new Trie();
            return arr[ch - '0'];
        }
    }
}

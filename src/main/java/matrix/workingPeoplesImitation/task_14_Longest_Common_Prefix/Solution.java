package matrix.workingPeoplesImitation.task_14_Longest_Common_Prefix;

import java.util.Arrays;

public class Solution {

    // my solution
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String word : strs) {
            if (word.length() == 0) return "";
            trie.addWord(word);
        }
        return strs[0].substring(0, trie.calculateCommonPrefix(strs.length));
    }

    private static class Trie {

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode('\0');
        }

        private int calculateCommonPrefix(int n) {
            TrieNode current = root;
            int count = 0;
            if (current.count != n) return count;
            for (int i = 0; i < 26; i++) {
                if (current.letters[i] != null) {
                    current = current.letters[i];
                    if (current.count != n) return count;
                    count++;
                    i = -1;
                }
            }
            return count;
        }

        private void addWord(String word) {
            TrieNode current = root;
            current.count++;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) current.letters[ch - 'a'] = new TrieNode(ch);
                current = current.letters[ch - 'a'];
                current.count++;
            }
        }

        private static class TrieNode {
            char letter;
            TrieNode[] letters;
            int count;

            public TrieNode(char letter) {
                this.letter = letter;
                this.letters = new TrieNode[26];
                this.count = 0;
            }
        }
    }

    // from leetcode editorial (Approach 1: Horizontal scanning)
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // from leetcode editorial (Approach 2: Vertical scanning)
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (
                        i == strs[j].length() || strs[j].charAt(i) != c
                ) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // from leetcode editorial (Approach 3: Divide and conquer)
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // from leetcode editorial (Approach 4: Binary search)
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) low = middle + 1;
            else high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) if (
                !strs[i].startsWith(str1)
        ) return false;
        return true;
    }

    // from leetcode editorial (Approach 5: Trie)
    public String longestCommonPrefix6(String q, String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Trie2 trie = new Trie2();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    class TrieNode {
        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        // number of children non null links
        private int size;

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getLinks() {
            return size;
        }

        // assume methods containsKey, isEnd, get, put are implemented as it is described
        // in  https://leetcode.com/articles/implement-trie-prefix-tree/)
        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie2 {
        private TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        // assume methods insert, search, searchPrefix are implemented as it is described
        // in  https://leetcode.com/articles/implement-trie-prefix-tree/)
        public String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (
                        node.containsKey(curLetter) &&
                                node.getLinks() == 1 &&
                                !node.isEnd()
                ) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                } else return prefix.toString();
            }
            return prefix.toString();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }
    }

    // from leetcode code sample
    public String longestCommonPrefix7(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    // from walkccc.me
    public String longestCommonPrefix8(String[] strs) {
        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); ++i)
            for (int j = 1; j < strs.length; ++j)
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);

        return strs[0];
    }

}

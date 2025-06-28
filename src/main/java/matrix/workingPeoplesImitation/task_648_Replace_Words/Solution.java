package matrix.workingPeoplesImitation.task_648_Replace_Words;

import java.util.List;

// my solution
public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary)
            trie.add(s);
        String[] arr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            String str = trie.findPrefix(s);
            if (str != null && !str.isEmpty())
                arr[i] = str;
            result.append(arr[i]).append(" ");
        }
        return result.toString().trim();
    }

    static class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) current.letters[ch - 'a'] = new TrieNode(ch);
                current = current.letters[ch - 'a'];
            }
            current.isEnd = true;
        }

        public String findPrefix(String word) {
            TrieNode current = root;
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) return null;
                current = current.letters[ch - 'a'];
                result.append(ch);
                if (current.isEnd) return result.toString();
            }
            return null;
        }

        static class TrieNode {
            char letter;
            TrieNode[] letters;
            boolean isEnd;
            public TrieNode(char letter) {
                this.letter = letter;
                this.letters = new TrieNode[26];
            }
        }
    }
}
